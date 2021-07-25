package mod.gptc.entity.gem;

import java.util.ArrayList;

import mod.gptc.entity.GemEntity;
import mod.gptc.entity.ai.EntityAIAttack;
import mod.gptc.entity.util.GemCuts;
import mod.gptc.entity.util.GemPlacements;
import mod.gptc.init.ModItems;
import mod.gptc.util.Colors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class GemRuby extends GemEntity implements IAnimatable {
	
	private static final int SKIN_COLOR_BEGIN = 0xE0316F;
	private static final int SKIN_COLOR_MID = 0xE52C5C;
	private static final int SKIN_COLOR_END = 0xED294C;
	
	private static final int HAIR_COLOR_BEGIN = 0xb80747;
	private static final int HAIR_COLOR_END = 0x8c0335;
	
	private static final int NUM_HAIRSTYLES = 1;
	
	private AnimationFactory factory = new AnimationFactory(this);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ruby.walk", true));
		} else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ruby.idle", true));
		}
		return PlayState.CONTINUE;
	}
	
	public GemRuby(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.FOREHEAD);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_EYE);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_EYE);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_EAR);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_EAR);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.TOP_OF_HEAD);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.BACK_OF_HEAD);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_SHOULDER);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_SHOULDER);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.BACK);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.CHEST);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.NAVAL);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_ARM);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_ARM);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_HAND);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_HAND);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_LEG);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_LEG);
		this.gemItem = ModItems.RUBY_GEM;
	}
	
	protected void initGoals() {
		this.targetSelector.add(100, new EntityAIAttack(this));
	}
	
    public static DefaultAttributeContainer.Builder createEntityAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 80.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5);
    }
	
	@Override
	protected int generateGemColor() {
		return 0xEE2331;
	}
	
	@Override
	protected int generateSkinColor() {
		ArrayList<Integer> skinColors = new ArrayList<Integer>();
		skinColors.add(GemRuby.SKIN_COLOR_BEGIN);
		skinColors.add(GemRuby.SKIN_COLOR_MID);
		skinColors.add(GemRuby.SKIN_COLOR_END);
		return Colors.arbiLerp(skinColors);
	}

	@Override
	protected int generateHairStyle() {
		return this.random.nextInt(GemRuby.NUM_HAIRSTYLES);
	}

	@Override
	protected int generateHairColor() {
		ArrayList<Integer> hairColors = new ArrayList<Integer>();
		hairColors.add(GemRuby.HAIR_COLOR_BEGIN);
		hairColors.add(GemRuby.HAIR_COLOR_END);
		return Colors.arbiLerp(hairColors);
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<GemRuby>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	public void attack(LivingEntity target, float pullProgress) {
		target.setFireTicks(20);
	}
}
