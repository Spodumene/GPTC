package mod.gptc.init;

import mod.gptc.GPTC;
import mod.gptc.item.ItemGemstone;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
	/******************************************
	 * This following items are all gemstones.*
	 ******************************************/
	/*The following have unknown hierarchy*/
	//Bixbites
	public static final ItemGemstone BIXBITE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "bixbite_gem", ModEntities.RUBY);
	//Rutiles
	public static final ItemGemstone RUTILE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "rutile_gem", ModEntities.RUBY);
	//Beetles
	public static final ItemGemstone HEAVEN_BEETLE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "heaven_beetle_gem", ModEntities.RUBY);
	public static final ItemGemstone EARTH_BEETLE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "earth_beetle_gem", ModEntities.RUBY);
	/*The above have unknown hierarchy*/
	//Pebbles
	public static final ItemGemstone PEBBLE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pebble_gem", ModEntities.RUBY);
	//Pearls
    public static final ItemGemstone RED_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_0", ModEntities.RUBY);
    public static final ItemGemstone ORANGE_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_1", ModEntities.RUBY);
    public static final ItemGemstone YELLOW_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_2", ModEntities.RUBY);
    public static final ItemGemstone LIME_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_3", ModEntities.RUBY);
    public static final ItemGemstone GREEN_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_4", ModEntities.RUBY);
    public static final ItemGemstone CYAN_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_5", ModEntities.RUBY);
    public static final ItemGemstone LIGHT_BLUE_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_6", ModEntities.RUBY);
    public static final ItemGemstone BLUE_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_7", ModEntities.RUBY);
    public static final ItemGemstone PURPLE_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_8", ModEntities.RUBY);
    public static final ItemGemstone MAGENTA_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_9", ModEntities.RUBY);
    public static final ItemGemstone PINK_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_10", ModEntities.RUBY);
    public static final ItemGemstone BROWN_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_11", ModEntities.RUBY);
    public static final ItemGemstone BLACK_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_12", ModEntities.RUBY);
    public static final ItemGemstone GRAY_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_13", ModEntities.RUBY);
    public static final ItemGemstone LIGHT_GRAY_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_14", ModEntities.RUBY);
    public static final ItemGemstone WHITE_PEARL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pearl_gem_15", ModEntities.RUBY);
	//Spinels
    public static final ItemGemstone YELLOW_SPINEL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spinel_gem_2", ModEntities.RUBY);
    public static final ItemGemstone BLUE_SPINEL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spinel_gem_7", ModEntities.RUBY);
    public static final ItemGemstone PINK_SPINEL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spinel_gem_10", ModEntities.RUBY);
    public static final ItemGemstone WHITE_SPINEL_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spinel_gem_15", ModEntities.RUBY);
	//Rubies
    public static final ItemGemstone RUBY_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "ruby_gem", ModEntities.RUBY);
    //Snowflake Obsidians
    public static final ItemGemstone SNOWFLAKE_OBSIDIAN_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "snowflake_obsidian_gem", ModEntities.RUBY);
    //Bismuth
    public static final ItemGemstone BISMUTH_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "bismuth_gem", ModEntities.RUBY);
    //Peridots
    public static final ItemGemstone PERIDOT_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "peridot_gem", ModEntities.RUBY);
    //Tourmalines
    public static final ItemGemstone RED_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_0", ModEntities.RUBY);
    public static final ItemGemstone ORANGE_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_1", ModEntities.RUBY);
    public static final ItemGemstone YELLOW_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_2", ModEntities.RUBY);
    public static final ItemGemstone LIME_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_3", ModEntities.RUBY);
    public static final ItemGemstone GREEN_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_4", ModEntities.RUBY);
    public static final ItemGemstone CYAN_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_5", ModEntities.RUBY);
    public static final ItemGemstone LIGHT_BLUE_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_6", ModEntities.RUBY);
    public static final ItemGemstone BLUE_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_7", ModEntities.RUBY);
    public static final ItemGemstone PURPLE_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_8", ModEntities.RUBY);
    public static final ItemGemstone MAGENTA_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_9", ModEntities.RUBY);
    public static final ItemGemstone PINK_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_10", ModEntities.RUBY);
    public static final ItemGemstone BROWN_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_11", ModEntities.RUBY);
    public static final ItemGemstone BLACK_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_12", ModEntities.RUBY);
    public static final ItemGemstone GRAY_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_13", ModEntities.RUBY);
    public static final ItemGemstone LIGHT_GRAY_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_14", ModEntities.RUBY);
    public static final ItemGemstone WHITE_TOURMALINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tourmaline_gem_15", ModEntities.RUBY);
    //Quartzes
    public static final ItemGemstone CARNELIAN_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "carnelian_gem", ModEntities.RUBY);
    public static final ItemGemstone CHERT_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "chert_gem", ModEntities.RUBY);
    public static final ItemGemstone CITRINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "citrine_gem", ModEntities.RUBY);
    public static final ItemGemstone FLINT_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "flint_gem", ModEntities.RUBY);
    public static final ItemGemstone ANGEL_AURA_QUARTZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "angel_aura_quartz_gem", ModEntities.RUBY);
    public static final ItemGemstone BLUE_QUARTZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "blue_quartz", ModEntities.RUBY);
    public static final ItemGemstone AMETHYST_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "amethyst_gem", ModEntities.RUBY);
    public static final ItemGemstone CHERRY_QUARTZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "cherry_quartz_gem", ModEntities.RUBY);
    public static final ItemGemstone ROSE_QUARTZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "rose_quartz_gem", ModEntities.RUBY);
    public static final ItemGemstone TIGERS_EYE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "tigers_eye_gem", ModEntities.RUBY);
    //Jaspers
    public static final ItemGemstone JASPER_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "jasper_gem_0", ModEntities.RUBY);
    public static final ItemGemstone BIGGS_JASPER_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "jasper_gem_1", ModEntities.RUBY);
    public static final ItemGemstone OCEAN_JASPER_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "jasper_gem_5", ModEntities.RUBY);
    public static final ItemGemstone ROYAL_PLUME_JASPER_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "jasper_gem_8", ModEntities.RUBY);
    public static final ItemGemstone ZEBRA_JASPER_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "jasper_gem_15", ModEntities.RUBY);
    //Agates
    public static final ItemGemstone CRAZY_LACE_AGATE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "agate_gem_2", ModEntities.RUBY);
    public static final ItemGemstone HOLLY_BLUE_AGATE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "agate_gem_6", ModEntities.RUBY);
    public static final ItemGemstone BLUE_LACE_AGATE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "agate_gem_7", ModEntities.RUBY);
    public static final ItemGemstone ROSE_AGATE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "agate_gem_10", ModEntities.RUBY);
    public static final ItemGemstone ONYX_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "agate_gem_12", ModEntities.RUBY);
    public static final ItemGemstone CLOUD_AGATE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "agate_gem_15", ModEntities.RUBY);
    //Zircons
    public static final ItemGemstone JACINTH_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_0", ModEntities.RUBY);
    public static final ItemGemstone ORANGE_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_1", ModEntities.RUBY);
    public static final ItemGemstone YELLOW_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_2", ModEntities.RUBY);
    public static final ItemGemstone LIME_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_3", ModEntities.RUBY);
    public static final ItemGemstone GREEN_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_4", ModEntities.RUBY);
    public static final ItemGemstone CYAN_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_5", ModEntities.RUBY);
    public static final ItemGemstone LIGHT_BLUE_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_6", ModEntities.RUBY);
    public static final ItemGemstone BLUE_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_7", ModEntities.RUBY);
    public static final ItemGemstone PURPLE_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_8", ModEntities.RUBY);
    public static final ItemGemstone MAGENTA_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_9", ModEntities.RUBY);
    public static final ItemGemstone PINK_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_10", ModEntities.RUBY);
    public static final ItemGemstone BROWN_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_11", ModEntities.RUBY);
    public static final ItemGemstone BLACK_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_12", ModEntities.RUBY);
    public static final ItemGemstone GRAY_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_13", ModEntities.RUBY);
    public static final ItemGemstone LIGHT_GRAY_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_14", ModEntities.RUBY);
    public static final ItemGemstone WHITE_ZIRCON_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "zircon_gem_15", ModEntities.RUBY);
    //Nephrites
    //public static final ItemGemstone NEPHRITE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "nephrite_gem");
    //Spodumenes
    public static final ItemGemstone RED_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_0", ModEntities.RUBY);
    public static final ItemGemstone ORANGE_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_1", ModEntities.RUBY);
    public static final ItemGemstone YELLOW_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_2", ModEntities.RUBY);
    public static final ItemGemstone LIME_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_3", ModEntities.RUBY);
    public static final ItemGemstone GREEN_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_4", ModEntities.RUBY);
    public static final ItemGemstone CYAN_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_5", ModEntities.RUBY);
    public static final ItemGemstone LIGHT_BLUE_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_6", ModEntities.RUBY);
    public static final ItemGemstone BLUE_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_7", ModEntities.RUBY);
    public static final ItemGemstone PURPLE_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_8", ModEntities.RUBY);
    public static final ItemGemstone MAGENTA_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_9", ModEntities.RUBY);
    public static final ItemGemstone PINK_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_10", ModEntities.RUBY);
    public static final ItemGemstone BROWN_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_11", ModEntities.RUBY);
    public static final ItemGemstone BLACK_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_12", ModEntities.RUBY);
    public static final ItemGemstone GRAY_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_13", ModEntities.RUBY);
    public static final ItemGemstone LIGHT_GRAY_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_14", ModEntities.RUBY);
    public static final ItemGemstone WHITE_SPODUMENE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "spodumene_gem_15", ModEntities.RUBY);
    //Topazes
    public static final ItemGemstone RED_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_0", ModEntities.RUBY);
    public static final ItemGemstone ORANGE_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_1", ModEntities.RUBY);
    public static final ItemGemstone YELLOW_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_2", ModEntities.RUBY);
    public static final ItemGemstone LIME_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_3", ModEntities.RUBY);
    public static final ItemGemstone GREEN_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_4", ModEntities.RUBY);
    public static final ItemGemstone CYAN_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_5", ModEntities.RUBY);
    public static final ItemGemstone LIGHT_BLUE_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_6", ModEntities.RUBY);
    public static final ItemGemstone BLUE_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_7", ModEntities.RUBY);
    public static final ItemGemstone PURPLE_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_8", ModEntities.RUBY);
    public static final ItemGemstone MAGENTA_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_9", ModEntities.RUBY);
    public static final ItemGemstone PINK_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_10", ModEntities.RUBY);
    public static final ItemGemstone BROWN_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_11", ModEntities.RUBY);
    public static final ItemGemstone BLACK_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_12", ModEntities.RUBY);
    public static final ItemGemstone GRAY_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_13", ModEntities.RUBY);
    public static final ItemGemstone LIGHT_GRAY_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_14", ModEntities.RUBY);
    public static final ItemGemstone WHITE_TOPAZ_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "topaz_gem_15", ModEntities.RUBY);
    //Larimars
    public static final ItemGemstone LARIMAR_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "larimar_gem", ModEntities.RUBY);
    //Lapis Lazulis
    public static final ItemGemstone LAPIS_LAZULI_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "lapis_lazuli_gem", ModEntities.RUBY);
    //Aquamarines
    public static final ItemGemstone AQUAMARINE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "aquamarine_gem", ModEntities.RUBY);
    //Sapphires
    public static final ItemGemstone ORANGE_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_1", ModEntities.RUBY);
    public static final ItemGemstone YELLOW_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_2", ModEntities.RUBY);
    public static final ItemGemstone LIME_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_3", ModEntities.RUBY);
    public static final ItemGemstone GREEN_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_4", ModEntities.RUBY);
    public static final ItemGemstone CYAN_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_5", ModEntities.RUBY);
    public static final ItemGemstone LIGHT_BLUE_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_6", ModEntities.RUBY);
    public static final ItemGemstone BLUE_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_7", ModEntities.RUBY);
    public static final ItemGemstone PURPLE_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_8", ModEntities.RUBY);
    public static final ItemGemstone MAGENTA_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_9", ModEntities.RUBY);
    public static final ItemGemstone PINK_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_10", ModEntities.RUBY);
    public static final ItemGemstone BROWN_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_11", ModEntities.RUBY);
    public static final ItemGemstone BLACK_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_12", ModEntities.RUBY);
    public static final ItemGemstone GRAY_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_13", ModEntities.RUBY);
    public static final ItemGemstone LIGHT_GRAY_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_14", ModEntities.RUBY);
    public static final ItemGemstone WHITE_SAPPHIRE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "sapphire_gem_15", ModEntities.RUBY);
    //Morganites
    public static final ItemGemstone MORGANITE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "morganite_gem", ModEntities.RUBY);
    //Garnets
    public static final ItemGemstone HESSONITE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "garnet_gem_1", ModEntities.RUBY);
    public static final ItemGemstone DEMANTOID_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "garnet_gem_3", ModEntities.RUBY);
    public static final ItemGemstone RHODOLITE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "garnet_gem_9", ModEntities.RUBY);
    public static final ItemGemstone PYROPE_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "garnet_gem_10", ModEntities.RUBY);
    //Emeralds
    public static final ItemGemstone EMERALD_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "emerald_gem", ModEntities.RUBY);
    //Diamonds
    public static final ItemGemstone WHITE_DIAMOND_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "white_diamond_gem", ModEntities.RUBY);
    public static final ItemGemstone YELLOW_DIAMOND_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "yellow_diamond_gem", ModEntities.RUBY);
    public static final ItemGemstone BLUE_DIAMOND_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "blue_diamond_gem", ModEntities.RUBY);
    public static final ItemGemstone PINK_DIAMOND_GEM = new ItemGemstone(new FabricItemSettings().group(GPTC.GEMSTONES).maxCount(1).fireproof(), "pink_diamond_gem", ModEntities.RUBY);
    
    public static final Item RUBY_SPAWN_EGG = new SpawnEggItem(ModEntities.RUBY, 0xE52C5C, 0x3B0015, new Item.Settings().group(ItemGroup.MISC));
    /****************************************
     *****The above items are gemstones.***** 
     ****************************************/ 
    public static void registerItems() {
		//Pebbles - Small gems that tinker around
    	Registry.register(Registry.ITEM, new Identifier("gptc", "pebble_gem"), PEBBLE_GEM);
		//Pearls - Tall yet skinny gems that have a large storage space
    	Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_0"), RED_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_1"), ORANGE_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_2"), YELLOW_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_3"), LIME_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_4"), GREEN_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_5"), CYAN_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_6"), LIGHT_BLUE_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_7"), BLUE_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_8"), PURPLE_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_9"), MAGENTA_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_10"), PINK_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_11"), BROWN_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_12"), BLACK_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_13"), GRAY_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_14"), LIGHT_GRAY_PEARL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "pearl_gem_15"), WHITE_PEARL_GEM);
		//Spinels - Entertainer gems that make sure gems don't rebel
		Registry.register(Registry.ITEM, new Identifier("gptc", "spinel_gem_2"), YELLOW_SPINEL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spinel_gem_7"), BLUE_SPINEL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spinel_gem_10"), PINK_SPINEL_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spinel_gem_15"), WHITE_SPINEL_GEM);
		//Rubies - Small fire soldiers
		Registry.register(Registry.ITEM, new Identifier("gptc", "ruby_gem"), RUBY_GEM);
	    //Snowflake Obsidians - A tall and beefy gem that can generate ice for the player.
		Registry.register(Registry.ITEM, new Identifier("gptc", "snowflake_obsidian_gem"), SNOWFLAKE_OBSIDIAN_GEM);
	    //Bismuth - A buff gem that can make any weapon and provide building blocks from very few materials.
		Registry.register(Registry.ITEM, new Identifier("gptc", "bismuth_gem"), BISMUTH_GEM);
	    //Peridots - Technology gems that can create technology, such as robonoids, when given materials.
		Registry.register(Registry.ITEM, new Identifier("gptc", "peridot_gem"), PERIDOT_GEM);
		//Tourmalines - Spikey soldiers that can provide heavy knockback.
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_0"), RED_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_1"), ORANGE_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_2"), YELLOW_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_3"), LIME_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_4"), GREEN_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_5"), CYAN_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_6"), LIGHT_BLUE_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_7"), BLUE_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_8"), PURPLE_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_9"), MAGENTA_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_10"), PINK_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_11"), BROWN_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_12"), BLACK_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_13"), GRAY_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_14"), LIGHT_GRAY_TOURMALINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tourmaline_gem_15"), WHITE_TOURMALINE_GEM);
    	//Bixbites - Mobile stonecutters
    	Registry.register(Registry.ITEM, new Identifier("gptc", "bixbite_gem"), BIXBITE_GEM);
    	//Rutiles - Thin scouts that go out during the night to find things while the player sleeps.
    	Registry.register(Registry.ITEM, new Identifier("gptc", "rutile_gem"), RUTILE_GEM);
	    //Quartzes - Buff soldiers that do great amounts of damage.
		Registry.register(Registry.ITEM, new Identifier("gptc", "carnelian_gem"), CARNELIAN_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "chert_gem"), CHERT_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "citrine_gem"), CITRINE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "flint_gem"), FLINT_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "angel_aura_quartz_gem"), ANGEL_AURA_QUARTZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "blue_quartz_gem"), BLUE_QUARTZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "amethyst_gem"), AMETHYST_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "cherry_quartz_gem"), CHERRY_QUARTZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "rose_quartz_gem"), ROSE_QUARTZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "tigers_eye_gem"), TIGERS_EYE_GEM);
	    //Jaspers - Quartzes that hit even harder.
		Registry.register(Registry.ITEM, new Identifier("gptc", "jasper_gem_0"), JASPER_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "jasper_gem_1"), BIGGS_JASPER_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "jasper_gem_5"), OCEAN_JASPER_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "jasper_gem_8"), ROYAL_PLUME_JASPER_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "jasper_gem_15"), ZEBRA_JASPER_GEM);
	    //Agates - Manager Quartzes that can manage groups of gems.
		Registry.register(Registry.ITEM, new Identifier("gptc", "agate_gem_2"), CRAZY_LACE_AGATE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "agate_gem_6"), HOLLY_BLUE_AGATE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "agate_gem_7"), BLUE_LACE_AGATE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "agate_gem_10"), ROSE_AGATE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "agate_gem_12"), ONYX_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "agate_gem_15"), CLOUD_AGATE_GEM);
	    //Zircons - Rare gems that can offer highly sought items for books and enchantments
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_0"), JACINTH_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_1"), ORANGE_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_2"), YELLOW_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_3"), LIME_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_4"), GREEN_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_5"), CYAN_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_6"), LIGHT_BLUE_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_7"), BLUE_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_8"), PURPLE_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_9"), MAGENTA_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_10"), PINK_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_11"), BROWN_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_12"), BLACK_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_13"), GRAY_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_14"), LIGHT_GRAY_ZIRCON_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "zircon_gem_15"), WHITE_ZIRCON_GEM);
		//Spodumenes - Water based warriors that move slow on land but fast under water, and can provide water breathing
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_0"), RED_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_1"), ORANGE_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_2"), YELLOW_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_3"), LIME_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_4"), GREEN_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_5"), CYAN_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_6"), LIGHT_BLUE_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_7"), BLUE_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_8"), PURPLE_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_9"), MAGENTA_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_10"), PINK_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_11"), BROWN_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_12"), BLACK_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_13"), GRAY_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_14"), LIGHT_GRAY_SPODUMENE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "spodumene_gem_15"), WHITE_SPODUMENE_GEM);
	    //Topazes - The strongest of the warriors. These gems can knock enemies far away like an Iron Golem.
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_0"), RED_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_1"), ORANGE_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_2"), YELLOW_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_3"), LIME_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_4"), GREEN_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_5"), CYAN_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_6"), LIGHT_BLUE_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_7"), BLUE_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_8"), PURPLE_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_9"), MAGENTA_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_10"), PINK_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_11"), BROWN_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_12"), BLACK_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_13"), GRAY_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_14"), LIGHT_GRAY_TOPAZ_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "topaz_gem_15"), WHITE_TOPAZ_GEM);
	    //Larimars - An infinite source of ice and snow, she can also provide ice sculptures.
		Registry.register(Registry.ITEM, new Identifier("gptc", "larimar_gem"), LARIMAR_GEM);
	    //Lapis Lazulis - A gem that can provide water breathing and can fly the player into the air.
		Registry.register(Registry.ITEM, new Identifier("gptc", "lapis_lazuli_gem"), LAPIS_LAZULI_GEM);
	    //Aquamarines - Small gems that can identify nearby enemies and deal small amounts of damage.
		Registry.register(Registry.ITEM, new Identifier("gptc", "aquamarine_gem"), AQUAMARINE_GEM);
	    //Sapphires - Prophetic gems that can predict the future.
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_1"), ORANGE_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_2"), YELLOW_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_3"), LIME_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_4"), GREEN_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_5"), CYAN_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_6"), LIGHT_BLUE_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_7"), BLUE_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_8"), PURPLE_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_9"), MAGENTA_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_10"), PINK_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_11"), BROWN_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_12"), BLACK_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_13"), GRAY_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_14"), LIGHT_GRAY_SAPPHIRE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "sapphire_gem_15"), WHITE_SAPPHIRE_GEM);
		//Morganites - Designer gems that can provide armor, blocks, and statues that are exclusive.
    	Registry.register(Registry.ITEM, new Identifier("gptc", "morganite_gem"), MORGANITE_GEM);
	    //Garnets - Aristocratic gems that can battle, and have varying abilities. Hessonites can teleport, Pyropes can knockback, Demantoid can summon Robonoids, and Rhodolite can heal her pals.
		Registry.register(Registry.ITEM, new Identifier("gptc", "garnet_gem_1"), HESSONITE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "garnet_gem_10"), PYROPE_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "garnet_gem_3"), DEMANTOID_GEM);
		Registry.register(Registry.ITEM, new Identifier("gptc", "garnet_gem_9"), RHODOLITE_GEM);
	    //Emeralds - Scouts that can disappear for long amounts of time, but will return with great rewards.
		Registry.register(Registry.ITEM, new Identifier("gptc", "emerald_gem"), EMERALD_GEM);
    	//Beetles - Constitutional gems that can hold information and provide support messages randomly.
    	Registry.register(Registry.ITEM, new Identifier("gptc", "heaven_beetle_gem"), HEAVEN_BEETLE_GEM);
    	Registry.register(Registry.ITEM, new Identifier("gptc", "earth_beetle_gem"), EARTH_BEETLE_GEM);
	    //Diamonds
    	Registry.register(Registry.ITEM, new Identifier("gptc", "white_diamond_gem"), WHITE_DIAMOND_GEM);
    	Registry.register(Registry.ITEM, new Identifier("gptc", "yellow_diamond_gem"), YELLOW_DIAMOND_GEM);
    	Registry.register(Registry.ITEM, new Identifier("gptc", "blue_diamond_gem"), BLUE_DIAMOND_GEM);
    	Registry.register(Registry.ITEM, new Identifier("gptc", "pink_diamond_gem"), PINK_DIAMOND_GEM);
    	
    	Registry.register(Registry.ITEM, new Identifier("gptc", "ruby_spawn_egg"), RUBY_SPAWN_EGG);
    }
}
