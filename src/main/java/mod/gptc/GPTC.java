package mod.gptc;

import mod.gptc.init.ModEntities;
import mod.gptc.init.ModItems;
import mod.gptc.init.ModLootTable;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class GPTC implements ModInitializer {
	/*Red = 0,
	 *Orange = 1,
	 *Yellow = 2,
	 *Lime = 3,
	 *Green = 4,
	 *Cyan = 5,
	 *Light Blue = 6,
	 *Blue = 7,
	 *Purple = 8,
	 *Magenta = 9,
	 *Pink = 10,
	 *Brown = 11,
	 *Black = 12,
	 *Gray = 13,
	 *Light Gray = 14,
	 *White = 15*/
	public static final ItemGroup GEMSTONES = FabricItemGroupBuilder.build(new Identifier("gptc", "gems"),() -> new ItemStack(ModItems.RUBY_GEM));
	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModLootTable.registerLoot();
		ModEntities.registerEntities();
	}
}
