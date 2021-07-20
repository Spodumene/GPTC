package mod.gptc.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.jetbrains.annotations.Nullable;

import mod.gptc.entity.ai.EntityAIFollow;
import mod.gptc.entity.ai.EntityAIWander;
import mod.gptc.entity.util.GemCuts;
import mod.gptc.entity.util.GemPlacements;
import mod.gptc.item.ItemGemstone;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class GemEntity extends PathAwareEntity {
	public static final TrackedData<Optional<UUID>> GEM_UUID = DataTracker.<Optional<UUID>>registerData(GemEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
	public static final TrackedData<Optional<UUID>> OWNER_UUID = DataTracker.<Optional<UUID>>registerData(GemEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
	public static final TrackedData<Boolean> OWNED = DataTracker.<Boolean>registerData(GemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<Boolean> DEFECTIVE = DataTracker.<Boolean>registerData(GemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<Boolean> PRIMARY = DataTracker.<Boolean>registerData(GemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<Integer> SKIN_TONE = DataTracker.<Integer>registerData(GemEntity.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> HAIR_DYE = DataTracker.<Integer>registerData(GemEntity.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> UNIFORM_COLOR = DataTracker.<Integer>registerData(GemEntity.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> INSIGNIA_COLOR = DataTracker.<Integer>registerData(GemEntity.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> GEM_COLOR = DataTracker.<Integer>registerData(GemEntity.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> HAIRSTYLE = DataTracker.<Integer>registerData(GemEntity.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> GEM_PLACEMENT = DataTracker.<Integer>registerData(GemEntity.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> GEM_CUT = DataTracker.<Integer>registerData(GemEntity.class, TrackedDataHandlerRegistry.INTEGER);
	
	//public boolean wantsToFuse;
	public byte movementType = 1;
	public ItemGemstone gemItem;
	
	protected HashMap<GemCuts, ArrayList<GemPlacements>> cutPlacements = new HashMap<GemCuts, ArrayList<GemPlacements>>();
	
	protected GemEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
		this.stepHeight = 0.6f;
		this.canBreatheInWater();
		this.cannotDespawn();
		this.setCustomName(this.getName());
		this.setCustomNameVisible(true);
		this.getBoundingBox().expand(3D);
	}
	
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(GEM_UUID, Optional.ofNullable(UUID.randomUUID()));
		this.dataTracker.startTracking(OWNED, false);
		this.dataTracker.startTracking(OWNER_UUID, Optional.ofNullable(UUID.randomUUID()));
		this.dataTracker.startTracking(PRIMARY, false);
		this.dataTracker.startTracking(DEFECTIVE, false);
		this.dataTracker.startTracking(SKIN_TONE, 0);
		this.dataTracker.startTracking(HAIR_DYE, 0);
		this.dataTracker.startTracking(UNIFORM_COLOR, 12);
		this.dataTracker.startTracking(INSIGNIA_COLOR, 12);
		this.dataTracker.startTracking(GEM_COLOR, 0);
		this.dataTracker.startTracking(HAIRSTYLE, 0);
		this.dataTracker.startTracking(GEM_CUT, -1);
		this.dataTracker.startTracking(GEM_PLACEMENT, -1);
	}
	
	protected void initGoals() {
        this.goalSelector.add(5, new SwimGoal(this));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(7, new EntityAIWander(this, 1.0D));
		this.goalSelector.add(7, new EntityAIFollow(this, 1.0D));
        this.initCustomGoals();
	}
	
	protected void initCustomGoals() {
		
	}
	
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		if (this.getGemId() == null) {
			nbt.putUuid("gemID", MathHelper.randomUuid());
		} else {
			nbt.putUuid("gemID", this.getGemId());
		}
		nbt.putInt("skinColor", this.getSkinColor());
		nbt.putInt("hairColor", this.getHairColor());
		nbt.putInt("insigniaColor", this.getInsigniaColor());
		nbt.putInt("uniformColor", this.getUniformColor());
		nbt.putInt("gemColor", this.getGemColor());
		nbt.putInt("hair", this.getHairStyle());
		nbt.putInt("gemPlacement", this.getGemPlacement().id);
		nbt.putInt("gemCut", this.getGemCut().id);
        nbt.putUuid("ownerID", this.getOwnerId());
        nbt.putBoolean("isOwned", this.getOwned());
        nbt.putBoolean("defective", this.isDefective());
        nbt.putBoolean("primary", this.isPrimary());
	}
	
	public void readCustomDataFromNbt(NbtCompound compound) {
		super.readCustomDataFromNbt(compound);
		this.setGemId(this.getGemId());
		this.setSkinColor(compound.getInt("skinColor"));
		this.setHairColor(compound.getInt("hairColor"));
		this.setInsigniaColor(compound.getInt("insigniaColor"));
		this.setUniformColor(compound.getInt("uniformColor"));
		this.setGemColor(compound.getInt("gemColor"));
		this.setHairStyle(compound.getInt("hair"));
		this.setGemPlacement(compound.getInt("gemPlacement"));
		this.setGemCut(compound.getInt("gemCut"));
        if(compound.contains("ownerID")) this.setOwnerId(compound.getUuid("ownerID"));
        this.setIsOwned(compound.getBoolean("isOwned"));
        this.setDefective(compound.getBoolean("defective"));
        this.setPrimary(compound.getBoolean("primary"));
	}
	
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
    	this.setHairStyle(this.generateHairStyle());
    	this.setSkinColor(this.generateSkinColor());
    	this.setHairColor(this.generateHairColor());
    	this.setGemColor(this.generateGemColor());
    	this.setUniformColor(this.getHairColor());
    	this.setInsigniaColor(this.getInsigniaColor());
    	this.setHealth(this.getMaxHealth());
    	if (!this.isGemPlacementDefined() || !this.isGemCutDefined() || !this.isCorrectCutPlacement()) {
			this.setNewCutPlacement();
		}
		this.setDefective(this.random.nextBoolean());
		if (!this.isDefective()) {
			this.setPrimary(this.random.nextBoolean());
		}
    	return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }
    
	@Override
	public final ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (!world.isClient()) {
			if (player.getMainHandStack().isEmpty()) {
				if (!player.isSneaking()) {
					if (!this.getOwned()) {
						this.setOwned(true, player.getUuid());
						this.setOwnerId(player.getUuid());
						this.setMovementType((byte) 2);
						player.sendMessage(new LiteralText("This gem belongs to you"), false);
					}
				} else {
					if (this.getOwned() == true) {
						if (this.getOwnerId().equals(player.getUuid()) && player.getActiveItem().isEmpty()) {
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
					if (this.getOwnerId().equals(player.getUuid())) {
						if (player.isSneaking()) {
							this.setInsigniaColor(dye.getColor().getId());	
						}
					} else {
						player.sendMessage(new LiteralText("This gem isn't yours"), false);
					}
				}
			}  else if (player.getMainHandStack().getItem() instanceof SwordItem) {
				if (this.getOwned() == true) {
					if (this.getOwnerId().equals(player.getUuid())) {
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
	
	@Override
	public boolean damage(DamageSource source, float amount) {
		if (source.isFromFalling() || source.isFallingBlock() || source.isFire()) {
			return false;
		}
		return super.damage(source, amount);
	}
    
	@Override
	public void onDeath(DamageSource cause) {
		this.world.addParticle(ParticleTypes.LARGE_SMOKE, this.getX(), this.getY() + this.getHeight() / 2, this.getZ(), 1.0D, 1.0D, 1.0D);
		ItemStack stack = new ItemStack(this.gemItem);
		if (!stack.isEmpty()) {
			((ItemGemstone) stack.getItem()).setData(this, stack);
			this.dropStack(stack, 1F);
		}
		super.onDeath(cause);
	}
	
	@Environment(EnvType.CLIENT)
    public void cycleMovementAI(PlayerEntity player){
        if (this.getMovementType() < 2){
            this.addMovementType(1);
            switch(this.getMovementType()){
                case 1:
                	player.sendMessage(new LiteralText("This gem will now wander"), false);
                    return;
                case 2:
                	player.sendMessage(new LiteralText("This gem will now follow"), false);
                    return;
                default:
                	player.sendMessage(new LiteralText("This gem will now stay"), false);
                    return;
            }
        }
        else if(this.getMovementType() == 2){
            this.setMovementType((byte) 0);
            player.sendMessage(new LiteralText("This gem will now stay"), false);
            return;
        }
    }
    
    public byte getMovementType(){
        return this.movementType;
    }

    public void setMovementType(byte value){
        this.movementType = value;
    }

    public void addMovementType(int value){
        this.movementType += value;
    }
    
	public void itemDataToGemData(int data) {
	}
	
	public void setNewCutPlacement() {
		Set<GemCuts> cuts = this.cutPlacements.keySet();
		int cutIndex = this.random.nextInt(cuts.size());
		GemCuts cut = (GemCuts) cuts.toArray()[cutIndex];

		ArrayList<GemPlacements> placements = this.cutPlacements.get(cut);
		int placementIndex = this.random.nextInt(placements.size());
		GemPlacements placement = placements.get(placementIndex);

		this.setGemCut(cut.id);
		this.setGemPlacement(placement.id);
	}
	
	public void setCutPlacement(GemCuts cut, GemPlacements placement) {
		if (this.cutPlacements.containsKey(cut)) {
			this.cutPlacements.get(cut).add(placement);
		} else {
			ArrayList<GemPlacements> placements = new ArrayList<GemPlacements>();
			placements.add(placement);
			this.cutPlacements.put(cut, placements);
		}
	}
	
	public void convertGems(int placement) {
	}

	public boolean isCorrectCutPlacement() {
		if (this.cutPlacements.containsKey(this.getGemCut())) {
			if (this.cutPlacements.get(this.getGemCut()).contains(this.getGemPlacement())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean isGemPlacementDefined() {
		return this.getGemPlacement() != GemPlacements.NONE;
	}
	
	public boolean isGemCutDefined() {
		return this.getGemCut() != GemCuts.NONE;
	}
	public GemCuts getGemCut() {
		return GemCuts.values()[this.dataTracker.get(GemEntity.GEM_CUT) + 1];
	}

	public void setGemCut(int gemCut) {
		this.dataTracker.set(GemEntity.GEM_CUT, gemCut);
	}

	public GemPlacements getGemPlacement() {
		return GemPlacements.values()[this.dataTracker.get(GemEntity.GEM_PLACEMENT) + 1];
	}

	public void setGemPlacement(int gemPlacement) {
		this.dataTracker.set(GemEntity.GEM_PLACEMENT, gemPlacement);
	}
	
	protected int generateSkinColor() {
		return 0;
	}
	
	public int getSkinColor() {
		return this.dataTracker.get(GemEntity.SKIN_TONE);
	}

	public void setSkinColor(int skinColor) {
		this.dataTracker.set(GemEntity.SKIN_TONE, skinColor);
	}

	protected int generateHairStyle() {
		return 0;
	}
	
	public int getHairStyle() {
		return this.dataTracker.get(GemEntity.HAIRSTYLE);
	}

	public void setHairStyle(int hairstyle) {
		this.dataTracker.set(GemEntity.HAIRSTYLE, hairstyle);
	}

	protected int generateHairColor() {
		return 0;
	}
	
	public int getHairColor() {
		return this.dataTracker.get(GemEntity.HAIR_DYE);
	}

	public void setHairColor(int hairColor) {
		this.dataTracker.set(GemEntity.HAIR_DYE, hairColor);
	}
	
	public boolean hasInsigniaVariant(GemPlacements placement) {
		return false;
	}

	public boolean hasUniformVariant(GemPlacements placement) {
		return false;
	}

	public boolean hasHairVariant(GemPlacements placement) {
		return false;
	}

	public boolean hasSkinVariant(GemPlacements placement) {
		return false;
	}
	
	protected int generateGemColor() {
		return 0xFFFFFF;
	}
	
	public int getGemColor() {
		return this.dataTracker.get(GemEntity.GEM_COLOR);
	}
	public void setGemColor(int color) {
		this.dataTracker.set(GemEntity.GEM_COLOR, color);
	}
	
	public int getInsigniaColor() {
		return this.dataTracker.get(GemEntity.INSIGNIA_COLOR);
	}

	public void setInsigniaColor(int insigniaColor) {
		this.dataTracker.set(GemEntity.INSIGNIA_COLOR, insigniaColor);
	}

	public int getUniformColor() {
		return this.dataTracker.get(GemEntity.UNIFORM_COLOR);
	}

	public void setUniformColor(int uniformColor) {
		this.dataTracker.set(GemEntity.UNIFORM_COLOR, uniformColor);
	}
	
	public void setGemId(UUID gemId) {
		this.dataTracker.set(GemEntity.GEM_UUID, Optional.ofNullable(gemId));
	}
	public void setGemId(String gemId) {
		this.dataTracker.set(GemEntity.GEM_UUID, Optional.ofNullable(UUID.fromString(gemId)));
	}
	public UUID getGemId() {
		return this.dataTracker.get(GemEntity.GEM_UUID).get();
	}
	
	public void setOwnerId(UUID gemId) {
		this.dataTracker.set(GemEntity.OWNER_UUID, Optional.ofNullable(gemId));
	}
	public void setOwnerId(String gemId) {
		this.dataTracker.set(GemEntity.OWNER_UUID, Optional.ofNullable(UUID.fromString(gemId)));
	}
	public UUID getOwnerId() {
		return this.dataTracker.get(GemEntity.OWNER_UUID).get();
	}
	
    public void setIsOwned(boolean value){
        this.dataTracker.set(GemEntity.OWNED, value);
    }

    public void setOwned(boolean value, @Nullable UUID ID){
        this.dataTracker.set(GemEntity.OWNED, value);
        if(value) {
            this.dataTracker.set(GemEntity.OWNER_UUID, Optional.ofNullable(ID));
        } else{
            this.dataTracker.set(GemEntity.OWNER_UUID, Optional.ofNullable(UUID.randomUUID()));
        }
    }
	
    public boolean getOwned(){
        return this.dataTracker.get(GemEntity.OWNED);
    }
	
	public boolean isDefective() {
		return this.dataTracker.get(GemEntity.DEFECTIVE);
	}

	public void setDefective(boolean defective) {
		this.dataTracker.set(GemEntity.DEFECTIVE, defective);
		if (defective) {
			this.whenDefective();
		}
	}

	public void whenDefective() {

	}

	public boolean isPrimary() {
		return this.dataTracker.get(GemEntity.PRIMARY);
	}

	public void setPrimary(boolean primary) {
		this.dataTracker.set(GemEntity.PRIMARY, primary);
		if (primary) {
			this.whenPrimary();
		}
	}

	public void whenPrimary() {

	}
}