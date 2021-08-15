package mod.gone.gptc.entity.bases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.jetbrains.annotations.Nullable;

import mod.gone.gptc.GPTC;
import mod.gone.gptc.entity.util.Abilities;
import mod.gone.gptc.entity.util.Elements;
import mod.gone.gptc.entity.util.GemCuts;
import mod.gone.gptc.entity.util.GemPlacements;
import mod.gone.gptc.item.ItemGemstone;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.RangedAttackMob;
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
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public abstract class EntityGem extends PathAwareEntity implements RangedAttackMob {
	//TODO: Rewrite following code.
	//The gem ID
	public static final TrackedData<Optional<UUID>> GEM_UUID = DataTracker.<Optional<UUID>>registerData(EntityGem.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
	//The owner ID
	public static final TrackedData<Optional<UUID>> OWNER_UUID = DataTracker.<Optional<UUID>>registerData(EntityGem.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
	//The entity they're following
	public static final TrackedData<Optional<UUID>> LEADER_UUID = DataTracker.<Optional<UUID>>registerData(EntityGem.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
	//The faction/group they're in. This may change later on, but it is a replacement to commander staffs.
	public static final TrackedData<Optional<UUID>> FACTION_UUID = DataTracker.<Optional<UUID>>registerData(EntityGem.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
	public static final TrackedData<Boolean> OWNED = DataTracker.<Boolean>registerData(EntityGem.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<Boolean> DEFECTIVE = DataTracker.<Boolean>registerData(EntityGem.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<Boolean> PRIMARY = DataTracker.<Boolean>registerData(EntityGem.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<Integer> SKIN_TONE = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
	//If the gem has a new uniform, the skin has to change in order to avoid Z-fighting.
	public static final TrackedData<Integer> SKIN_VARIANT = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> HAIR_DYE = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> UNIFORM_COLOR = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
    public static final TrackedData<Integer> UNIFORM_VARIANT = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> INSIGNIA_COLOR = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> GEM_COLOR = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> HAIRSTYLE = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Integer> GEM_PLACEMENT = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
	//Yes, this is a system used by KAGIC, but it may be kept due to how much I favor the system.
	public static final TrackedData<Integer> GEM_CUT = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Boolean> VISOR = DataTracker.<Boolean>registerData(EntityGem.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<Boolean> DRESS = DataTracker.<Boolean>registerData(EntityGem.class, TrackedDataHandlerRegistry.BOOLEAN);
	
	//Elements tell them how to react when attacking or being attacked
	public static final TrackedData<Integer> ELEMENT = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
	//Emotional abilities happen when a gem is hurt, has damaged friends, or something else. They vary per gem, and act similarly to Steven throughout the show.
	public static final TrackedData<Integer> EMOTIONAL_ABILITY = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
	
	//I'm gonna use this until I figure out a real system.
	public static final TrackedData<String> FUSION_PLACEMENT = DataTracker.<String>registerData(EntityGem.class, TrackedDataHandlerRegistry.STRING);
	public static final TrackedData<Integer> FUSION_COUNT = DataTracker.<Integer>registerData(EntityGem.class, TrackedDataHandlerRegistry.INTEGER);
	public ArrayList<NbtCompound> fusionMembers = new ArrayList<NbtCompound>();
	public boolean wantsToFuse;
	
	public boolean dressAble;
    public ItemGemstone gemItem;
    protected float pitch = 1.0F;
    public int visorChances = 5; //1 in 5 gems will have a visor.
    public int dressChances = 25; //1 in 25 gems will have a dress.
	public int betrayal = -1;
	public int timeUntilBetrayal;
	public int serving = 0;
	public String getWholeGemName = "";
    public int emotionalValue = 0;
    public int initalSkinVariant = 0;
    public boolean setSkinVariantOnInitialSpawn = true;
	
	protected HashMap<GemCuts, ArrayList<GemPlacements>> cutPlacements = new HashMap<GemCuts, ArrayList<GemPlacements>>();
	
	protected EntityGem(EntityType<? extends PathAwareEntity> entityType, World world) {
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
		this.dataTracker.startTracking(LEADER_UUID, Optional.ofNullable(UUID.randomUUID()));
		this.dataTracker.startTracking(FACTION_UUID, Optional.ofNullable(UUID.randomUUID()));
		this.dataTracker.startTracking(PRIMARY, false);
		this.dataTracker.startTracking(DEFECTIVE, false);
		this.dataTracker.startTracking(SKIN_TONE, 0);
		this.dataTracker.startTracking(HAIR_DYE, 0);
		this.dataTracker.startTracking(UNIFORM_COLOR, 12);
		this.dataTracker.startTracking(UNIFORM_VARIANT, 0);
		this.dataTracker.startTracking(INSIGNIA_COLOR, 12);
		this.dataTracker.startTracking(GEM_COLOR, 0);
		this.dataTracker.startTracking(HAIRSTYLE, 0);
		this.dataTracker.startTracking(GEM_CUT, -1);
		this.dataTracker.startTracking(GEM_PLACEMENT, -1);
		this.dataTracker.startTracking(SKIN_VARIANT, 0);
		this.dataTracker.startTracking(FUSION_COUNT, 0);
		this.dataTracker.startTracking(FUSION_PLACEMENT, "");
		this.dataTracker.startTracking(VISOR, false);
		this.dataTracker.startTracking(DRESS, false);
		this.dataTracker.startTracking(ELEMENT, 0);
		this.dataTracker.startTracking(EMOTIONAL_ABILITY, 0);
	}
	
	protected void initGoals() {
		this.goalSelector.add(5, new SwimGoal(this));
		this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
		this.goalSelector.add(3, new LookAroundGoal(this));
	}
	
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		if (this.getGemId() == null) {
			nbt.putUuid("gemID", MathHelper.randomUuid());
		} else {
			nbt.putUuid("gemID", this.getGemId());
		}
        nbt.putInt("skinVariant", this.getSkinVariant());
		nbt.putInt("skinColor", this.getSkinColor());
		nbt.putInt("hairColor", this.getHairColor());
		nbt.putInt("insigniaColor", this.getInsigniaColor());
		nbt.putInt("uniformColor", this.getUniformColor());
		nbt.putInt("gemColor", this.getGemColor());
		nbt.putInt("hair", this.getHairStyle());
		nbt.putInt("gemPlacement", this.getGemPlacement().id);
		nbt.putInt("gemCut", this.getGemCut().id);
		nbt.putInt("element", this.getElement().id);
		nbt.putInt("ability", this.getAbility().id);
        nbt.putUuid("ownerID", this.getOwnerId());
        nbt.putBoolean("isOwned", this.getOwned());
        nbt.putBoolean("defective", this.isDefective());
        nbt.putBoolean("primary", this.isPrimary());
		nbt.putBoolean("visor", this.hasVisor());
		nbt.putBoolean("dress", this.hasDress());
        nbt.putBoolean("wantsToFuse", this.wantsToFuse);
        nbt.putFloat("pitch", this.pitch);
	}
	
	public void readCustomDataFromNbt(NbtCompound compound) {
		super.readCustomDataFromNbt(compound);
		this.setGemId(this.getGemId());
		this.setElement(compound.getInt("element"));
		this.setAbility(compound.getInt("ability"));
        this.setSkinVariant(compound.getInt("skinVariant"));
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
        this.setHasVisor(compound.getBoolean("visor"));
        this.setHasDress(compound.getBoolean("dress"));
        this.setDefective(compound.getBoolean("defective"));
        this.setPrimary(compound.getBoolean("primary"));
        if (compound.contains("pitch")) {
			this.pitch = compound.getFloat("pitch");
		} else {
			this.pitch = 0.7F + this.random.nextFloat() / 2;
		}
        this.wantsToFuse = compound.getBoolean("wantsToFuse");
	}
	
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
    	this.setSkinVariant(this.generateSkinVariant());
    	this.setSkinColor(this.generateSkinColor());
    	this.setHairStyle(this.generateHairStyle());
    	this.setSkinColor(this.generateSkinColor());
    	this.setHairColor(this.generateHairColor());
    	this.setGemColor(this.generateGemColor());
    	this.setUniformColor(this.generateUniformColor());
    	this.setInsigniaColor(0xFFFFFF);
    	this.setUniformVariant(this.generateUniformVariant());
    	this.setInsigniaColor(this.generateInsigniaVariant());
    	this.setHasVisor(this.random.nextInt(this.visorChances) == 0);
    	this.setHasDress(this.random.nextInt(this.dressChances) == 0);
    	this.setHealth(this.getMaxHealth());
    	if (!this.isGemPlacementDefined() || !this.isGemCutDefined() || !this.isCorrectCutPlacement()) {
			this.setNewCutPlacement();
		}
		this.setDefective(this.random.nextBoolean());
		if (!this.isDefective()) {
			this.setPrimary(this.random.nextBoolean());
		}
		this.pitch = 0.7F + this.random.nextFloat() / 2;
    	return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }
    
   /* public void tick() {
    	if (!world.isClient()) {
    		if (this.timeUntilBetrayal > this.random.nextDouble() * 4 * 24000) {
    			this.setOwnerId(this.getOwnerId());
    		} else {
    			this.setOwnerId(this.getUuid());
    		}
    		++this.timeUntilBetrayal;
    	}
    	super.tick();
    }*/
    
    public void rejuvenate() {
    	this.setUniformColor(this.generateUniformColor());
    	this.setIsOwned(false);
    }
    
	@Override
	public final ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (!world.isClient()) {
			if (player.getMainHandStack().isEmpty()) {
				if (!player.isSneaking()) {
					if (!this.getOwned()) {
						this.setOwned(true, player.getUuid());
						this.setOwnerId(player.getUuid());
						player.sendMessage(new LiteralText("This gem belongs to you"), false);
					}
				} else {
					if (this.getOwned() == true) {
						if (this.getOwnerId().equals(player.getUuid()) && player.getActiveItem().isEmpty()) {
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
			}
		}
		return ActionResult.SUCCESS;
	}
	
	public boolean damage(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		}
		return super.damage(source, amount);
	}
	
    public boolean isInvulnerableTo(DamageSource damageSource) {
        if (damageSource == DamageSource.DROWN || damageSource == DamageSource.FALL || damageSource == DamageSource.FLY_INTO_WALL || damageSource == DamageSource.FREEZE || damageSource == DamageSource.IN_FIRE || damageSource == DamageSource.IN_WALL || damageSource == DamageSource.LAVA || damageSource == DamageSource.ON_FIRE) {
            return true;
        } else {
            return super.isInvulnerableTo(damageSource);
        }
    }
    
	@Override
	public void attack(LivingEntity target, float pullProgress) {
	}
    
	@Override
	public void onDeath(DamageSource cause) {
		this.getEntityWorld().addParticle(ParticleTypes.LARGE_SMOKE, this.getX(), this.getY() + this.getHeight() / 2, this.getZ(), 1.0D, 1.0D, 1.0D);
		ItemStack stack = new ItemStack(this.gemItem);
		if (!stack.isEmpty()) {
			((ItemGemstone) stack.getItem()).setData(this, stack);
			this.dropStack(stack, 1F);
		}
		super.onDeath(cause);
	}
    
	public void itemDataToGemData(int data) {
	}
	
	//Gemstone stuff
	
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
		return GemCuts.values()[this.dataTracker.get(EntityGem.GEM_CUT) + 1];
	}

	public void setGemCut(int gemCut) {
		this.dataTracker.set(EntityGem.GEM_CUT, gemCut);
	}

	public GemPlacements getGemPlacement() {
		return GemPlacements.values()[this.dataTracker.get(EntityGem.GEM_PLACEMENT) + 1];
	}

	public void setGemPlacement(int gemPlacement) {
		this.dataTracker.set(EntityGem.GEM_PLACEMENT, gemPlacement);
	}
	
	//Abilities
	
	public Abilities getAbility() {
		return Abilities.values()[this.dataTracker.get(EntityGem.EMOTIONAL_ABILITY) + 1];
	}
	
	public void setAbility(int ability) {
		this.dataTracker.set(EntityGem.EMOTIONAL_ABILITY, ability);
	}
	
	public Elements getElement() {
		return Elements.values()[this.dataTracker.get(EntityGem.ELEMENT) + 1];
	}
	
	public void setElement(int ability) {
		this.dataTracker.set(EntityGem.ELEMENT, ability);
	}
	
    public String getModID(){
        return GPTC.MODID;
    }
    
    //Skin
	
	public int generateSkinColor() {
		return 0;
	}
	
	public int getSkinColor() {
		return this.dataTracker.get(EntityGem.SKIN_TONE);
	}

	public void setSkinColor(int skinColor) {
		this.dataTracker.set(EntityGem.SKIN_TONE, skinColor);
	}

    public abstract int generateSkinColorVariant();

    public abstract boolean hasSkinColorVariant();
    
    public abstract int generateSkinVariant();

    public int getSkinVariant(){
        return this.dataTracker.get(EntityGem.SKIN_VARIANT);
    }

    public void setSkinVariant(int value){
        this.dataTracker.set(EntityGem.SKIN_VARIANT, value);
    }

	public boolean hasSkinVariant(GemPlacements placement) {
		return false;
	}
	
	//Hair
	
	public int generateHairStyle() {
		return 0;
	}
	
	public int getHairStyle() {
		return this.dataTracker.get(EntityGem.HAIRSTYLE);
	}

	public void setHairStyle(int hairstyle) {
		this.dataTracker.set(EntityGem.HAIRSTYLE, hairstyle);
	}

	public int generateHairColor() {
		return 0;
	}
	
	public int getHairColor() {
		return this.dataTracker.get(EntityGem.HAIR_DYE);
	}

	public void setHairColor(int hairColor) {
		this.dataTracker.set(EntityGem.HAIR_DYE, hairColor);
	}

	public boolean hasHairVariant(GemPlacements placement) {
		return false;
	}
	
    public abstract int generateHairVariant();
	
	//Gemstone
	
	public int generateGemColor() {
		return 0xFFFFFF;
	}
	
	public int getGemColor() {
		return this.dataTracker.get(EntityGem.GEM_COLOR);
	}
	public void setGemColor(int color) {
		this.dataTracker.set(EntityGem.GEM_COLOR, color);
	}
	
	//Insignia
	
	public int getInsigniaColor() {
		return this.dataTracker.get(EntityGem.INSIGNIA_COLOR);
	}

	public void setInsigniaColor(int insigniaColor) {
		this.dataTracker.set(EntityGem.INSIGNIA_COLOR, insigniaColor);
	}
	
	public boolean hasInsigniaVariant(GemPlacements placement) {
		return false;
	}
	
    public abstract int generateInsigniaVariant();
	
	//Uniform Stuff

	public int getUniformColor() {
		return this.dataTracker.get(EntityGem.UNIFORM_COLOR);
	}

	public void setUniformColor(int uniformColor) {
		this.dataTracker.set(EntityGem.UNIFORM_COLOR, uniformColor);
	}
	
    public int generateUniformColor(){
        return 0xFFFFFF;
    }
    
	public boolean hasUniformVariant(GemPlacements placement) {
		return false;
	}
	
    public abstract int generateUniformVariant();

    public void setUniformVariant(int value){
        this.dataTracker.set(EntityGem.UNIFORM_VARIANT, value);
    }

    public int getUniformVariant(){
        return this.dataTracker.get(EntityGem.UNIFORM_VARIANT);
    }
    
    public boolean hasUniformPlacementVariant(){
        return false;
    }

    public int[] uniformPlacementVariants(){
        return new int[]{};
    }
	
	/***************
	 * Gem ID stuff*
	 * *************/
    
	public void setGemId(UUID gemId) {
		this.dataTracker.set(EntityGem.GEM_UUID, Optional.ofNullable(gemId));
	}
	public void setGemId(String gemId) {
		this.dataTracker.set(EntityGem.GEM_UUID, Optional.ofNullable(UUID.fromString(gemId)));
	}
	public UUID getGemId() {
		return this.dataTracker.get(EntityGem.GEM_UUID).get();
	}
	
	/**************
	 * Owner stuff*
	 * ************/
	
	public void setOwnerId(UUID gemId) {
		this.dataTracker.set(EntityGem.OWNER_UUID, Optional.ofNullable(gemId));
	}
	public void setOwnerId(String gemId) {
		this.dataTracker.set(EntityGem.OWNER_UUID, Optional.ofNullable(UUID.fromString(gemId)));
	}
	public UUID getOwnerId() {
		return this.dataTracker.get(EntityGem.OWNER_UUID).get();
	}
	
    public void setIsOwned(boolean value){
        this.dataTracker.set(EntityGem.OWNED, value);
    }

    public void setOwned(boolean value, @Nullable UUID ID){
        this.dataTracker.set(EntityGem.OWNED, value);
        if(value) {
            this.dataTracker.set(EntityGem.OWNER_UUID, Optional.ofNullable(ID));
        } else{
            this.dataTracker.set(EntityGem.OWNER_UUID, Optional.ofNullable(UUID.randomUUID()));
        }
    }
	
    public boolean getOwned(){
        return this.dataTracker.get(EntityGem.OWNED);
    }
    
	public PlayerEntity getOwner() {
		PlayerEntity owner = null;
		double distance = Double.MAX_VALUE;
		for (PlayerEntity playerIn : this.world.getPlayers()) {
			if (PlayerEntity.getUuidFromProfile(playerIn.getGameProfile()).equals(this.getOwnerId())) {
				if (this.squaredDistanceTo(playerIn.getPos()) <= distance) {
					distance = this.squaredDistanceTo(playerIn.getPos());
					owner = playerIn;
				}
			}
		}
		return owner;
	}
    
    /*******************
     * Leadership stuff*
     * *****************/
    
	public void setLeaderId(UUID gemId) {
		this.dataTracker.set(EntityGem.GEM_UUID, Optional.ofNullable(gemId));
	}
	public void setLeaderId(String gemId) {
		this.dataTracker.set(EntityGem.GEM_UUID, Optional.ofNullable(UUID.fromString(gemId)));
	}
	public UUID getLeaderId() {
		return this.dataTracker.get(EntityGem.GEM_UUID).get();
	}
    
    /************************
     * Defective and Primary*
     * **********************/
	
	public boolean isDefective() {
		return this.dataTracker.get(EntityGem.DEFECTIVE);
	}

	public void setDefective(boolean defective) {
		this.dataTracker.set(EntityGem.DEFECTIVE, defective);
		if (defective) {
			this.whenDefective();
		}
	}

	public void whenDefective() {

	}

	public boolean isPrimary() {
		return this.dataTracker.get(EntityGem.PRIMARY);
	}

	public void setPrimary(boolean primary) {
		this.dataTracker.set(EntityGem.PRIMARY, primary);
		if (primary) {
			this.whenPrimary();
		}
	}

	public void whenPrimary() {

	}
	
	/*********************
	 * Visors and Dresses*
	 * *******************/
    
	public boolean hasVisor() {
		return this.dataTracker.get(EntityGem.VISOR);
	}

	public void setHasVisor(boolean hasVisor) {
		this.dataTracker.set(EntityGem.VISOR, hasVisor);
	}
	
	public boolean hasDress() {
		return this.dataTracker.get(EntityGem.DRESS);
	}

	public void setHasDress(boolean hasVisor) {
		this.dataTracker.set(EntityGem.DRESS, hasVisor);
	}
	
	/**************************************
	 * The following is related to sounds.*
	 * ************************************/
	
	@Override
	public float getSoundVolume() {
		return super.getSoundVolume();
	}

	@Override
	public float getSoundPitch() {
		return this.pitch;
	}

	protected SoundEvent getObeySound() {
		return null;
	}

	public void playObeySound() {
		if (this.getObeySound() != null) {
			this.playSound(this.getObeySound(), this.getSoundVolume(), this.getSoundPitch());
		}
	}

	@Override
	public void playAmbientSound() {
		super.playAmbientSound();
	}

	@Override
	public void playHurtSound(DamageSource source) {
		super.playHurtSound(source);
	}
}
