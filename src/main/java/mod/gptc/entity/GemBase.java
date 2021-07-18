package mod.gptc.entity;

import java.util.Optional;
import java.util.UUID;

import org.jetbrains.annotations.Nullable;

import mod.gptc.entity.ai.EntityAIFollow;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class GemBase extends GemEntity {
	public static final TrackedData<Optional<UUID>> OWNER_UUID = DataTracker.<Optional<UUID>>registerData(GemEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
	public static final TrackedData<Boolean> OWNED = DataTracker.<Boolean>registerData(GemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<Boolean> DEFECTIVE = DataTracker.<Boolean>registerData(GemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<Boolean> PRIMARY = DataTracker.<Boolean>registerData(GemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	
    public enum GemAlignments{
        SELF,
        PLAYER,
        GEM,
        ENTITY
    }
	
	protected GemBase(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
	}

	
	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(OWNED, false);
		this.dataTracker.startTracking(OWNER_UUID, Optional.ofNullable(UUID.randomUUID()));
		this.dataTracker.startTracking(PRIMARY, false);
		this.dataTracker.startTracking(DEFECTIVE, false);
	}
	
	@Override
	protected void initGoals() {
		this.goalSelector.add(7, new EntityAIFollow(this, 1.0D));
	}
	
	@Nullable
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.setDefective(this.random.nextBoolean());
		if (!this.isDefective()) {
			this.setPrimary(this.random.nextBoolean());
		}
		this.setOwnerId(this.getOwnerId());
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}
	
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
        nbt.putUuid("ownerID", this.getOwnerId());
        nbt.putBoolean("isOwned", this.getOwned());
        nbt.putBoolean("defective", this.isDefective());
        nbt.putBoolean("primary", this.isPrimary());
	}
	
	public void readCustomDataFromNbt(NbtCompound compound) {
		super.readCustomDataFromNbt(compound);
        if(compound.contains("ownerID")) this.setOwnerId(compound.getUuid("ownerID"));
        this.setIsOwned(compound.getBoolean("isOwned"));
        this.setDefective(compound.getBoolean("defective"));
        this.setPrimary(compound.getBoolean("primary"));
	}

	@Override
	public final ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (!world.isClient()) {
			if (player.getMainHandStack().isEmpty()) {
				if (!player.isSneaking()) {
					if (!this.getOwned()) {
						this.setOwned(true, player.getUuid());
						this.setMovementType((byte) 2);
						player.sendMessage(new LiteralText("This gem belongs to you"), false);
					}
				} else {
					if (this.getOwned() == true) {
						if (this.getOwnerId() == player.getUuid() && player.getActiveItem().isEmpty()) {
							this.cycleMovementAI(player);
						} else {
							player.sendMessage(new LiteralText("This gem isn't yours"), false);
						}
					}
				}
				return ActionResult.SUCCESS;
			} else if (player.getMainHandStack().getItem() instanceof DyeItem) {
				DyeItem dye = (DyeItem) player.getMainHandStack().getItem();
				if (this.getOwned() == true) {
					if (this.getOwnerId() == player.getUuid()) {
						if (player.isSneaking()) {
							this.setInsigniaColor(dye.getColor().getId());	
						}
					} else {
						player.sendMessage(new LiteralText("This gem isn't yours"), false);
					}
				}
			}  else if (player.getMainHandStack().getItem() instanceof SwordItem) {
				if (this.getOwned() == true) {
					if (this.getOwnerId() == player.getUuid()) {
						this.setHealth(1);
						player.sendMessage(new LiteralText("This gem is ready for poofing"), false);
					} else {
						player.sendMessage(new LiteralText("This gem isn't yours"), false);
					}
				}
			}
		}
		return ActionResult.SUCCESS;
	}
	
	public void setOwnerId(UUID ownerId) {
		this.dataTracker.set(GemBase.OWNER_UUID, Optional.ofNullable(ownerId));
	}

	public void setOwnerId(String ownerId) {
		this.dataTracker.set(GemBase.OWNER_UUID, Optional.ofNullable(UUID.fromString(ownerId)));
	}

	public UUID getOwnerId() {
		return this.dataTracker.get(GemBase.OWNER_UUID).get();
	}
	
    public void setIsOwned(boolean value){
        this.dataTracker.set(GemBase.OWNED, value);
    }

    public void setOwned(boolean value, @Nullable UUID ID){
        this.dataTracker.set(GemBase.OWNED, value);
        if(value) {
            this.dataTracker.set(GemBase.OWNER_UUID, Optional.ofNullable(ID));
        } else{
            this.dataTracker.set(GemBase.OWNER_UUID, Optional.ofNullable(UUID.randomUUID()));
        }
    }
	
    public boolean getOwned(){
        return this.dataTracker.get(GemBase.OWNED);
    }
	
	public boolean isDefective() {
		return this.dataTracker.get(GemBase.DEFECTIVE);
	}

	public void setDefective(boolean defective) {
		this.dataTracker.set(GemBase.DEFECTIVE, defective);
		if (defective) {
			this.whenDefective();
		}
	}

	public void whenDefective() {

	}

	public boolean isPrimary() {
		return this.dataTracker.get(GemBase.PRIMARY);
	}

	public void setPrimary(boolean primary) {
		this.dataTracker.set(GemBase.PRIMARY, primary);
		if (primary) {
			this.whenPrimary();
		}
	}

	public void whenPrimary() {

	}

}