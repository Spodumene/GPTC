package mod.gptc.entity.gem;

import java.util.ArrayList;

import mod.gptc.entity.GemEntity;
import mod.gptc.entity.util.GemCuts;
import mod.gptc.entity.util.GemPlacements;
import mod.gptc.init.ModItems;
import mod.gptc.util.Colors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class GemRuby extends GemEntity {
	private static final int SKIN_COLOR_BEGIN = 0xE0316F;
	private static final int SKIN_COLOR_MID = 0xE52C5C;
	private static final int SKIN_COLOR_END = 0xED294C;
	
	private static final int HAIR_COLOR_BEGIN = 0x3B0015;
	private static final int HAIR_COLOR_END = 0x3A0015;
	
	private static final int NUM_HAIRSTYLES = 1;
	
	public GemRuby(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.BACK_OF_HEAD);
		this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(80D);
		//this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(5D);
		this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.4D);
		this.gemItem = ModItems.RUBY_GEM;
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
	
	
}
