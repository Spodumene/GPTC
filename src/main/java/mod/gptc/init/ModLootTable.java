package mod.gptc.init;

import java.util.List;

import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class ModLootTable {
	private static final List<LootTableInsert> INSERTS = Lists.newArrayList();

	public static void registerLoot() {
		FabricLootPoolBuilder PEBBLE_LOOT = FabricLootPoolBuilder.builder()
			.rolls(ConstantLootNumberProvider.create(1))
			.with(ItemEntry.builder(ModItems.PEBBLE_GEM))
			.withCondition(RandomChanceLootCondition.builder(0.5F).build());

			insert(new LootTableInsert(PEBBLE_LOOT,
				new Identifier("minecraft", "chests/desert_pyramid"),
				new Identifier("minecraft", "chests/abandoned_mineshaft"),
				new Identifier("minecraft", "gameplay/fishing/treasure"),
				new Identifier("minecraft", "chests/buried_treasure"),
				new Identifier("minecraft", "chests/jungle_temple"),
				new Identifier("minecraft", "chests/woodland_mansion")
			));
			FabricLootPoolBuilder RUBY_LOOT = FabricLootPoolBuilder.builder()
					.rolls(ConstantLootNumberProvider.create(1))
					.with(ItemEntry.builder(ModItems.RUBY_GEM))
					.withCondition(RandomChanceLootCondition.builder(0.5F).build());

					insert(new LootTableInsert(RUBY_LOOT,
						new Identifier("minecraft", "chests/desert_pyramid"),
						new Identifier("minecraft", "chests/abandoned_mineshaft"),
						new Identifier("minecraft", "chests/nether_bridge"),
						new Identifier("minecraft", "chests/bastion_bridge"),
						new Identifier("minecraft", "chests/ruined_portal"),
						new Identifier("minecraft", "chests/woodland_mansion")
					));
					FabricLootPoolBuilder LAPIS_LOOT = FabricLootPoolBuilder.builder()
							.rolls(ConstantLootNumberProvider.create(1))
							.with(ItemEntry.builder(ModItems.LAPIS_LAZULI_GEM))
							.withCondition(RandomChanceLootCondition.builder(0.5F).build());

							insert(new LootTableInsert(LAPIS_LOOT,
								new Identifier("minecraft", "chests/buried_treasure"),
								new Identifier("minecraft", "chests/igloo_chest"),
								new Identifier("minecraft", "chests/shipwreck_supply"),
								new Identifier("minecraft", "chests/shipwreck_treasure"),
								new Identifier("minecraft", "chests/underwater_ruin_big"),
								new Identifier("minecraft", "chests/underwater_ruin_small")
							));
							FabricLootPoolBuilder SAPPHIRE_LOOT = FabricLootPoolBuilder.builder()
									.rolls(ConstantLootNumberProvider.create(1))
									.with(ItemEntry.builder(ModItems.LAPIS_LAZULI_GEM))
									.withCondition(RandomChanceLootCondition.builder(0.5F).build());

									insert(new LootTableInsert(SAPPHIRE_LOOT,
										new Identifier("minecraft", "chests/buried_treasure"),
										new Identifier("minecraft", "chests/igloo_chest"),
										new Identifier("minecraft", "chests/shipwreck_supply"),
										new Identifier("minecraft", "chests/shipwreck_treasure"),
										new Identifier("minecraft", "chests/underwater_ruin_big"),
										new Identifier("minecraft", "chests/underwater_ruin_small")
									));
			LootTableLoadingCallback.EVENT.register(((resourceManager, lootManager, identifier, supplier, lootTableSetter) -> {
				INSERTS.forEach(i->{
				if(ArrayUtils.contains(i.tables, identifier)) {
					i.insert(supplier);
				}
			});
		}));
	}

	public static void insert(LootTableInsert insert) {
		INSERTS.add(insert);
	}

	public static class LootTableInsert {
		public final Identifier[] tables;
		public final FabricLootPoolBuilder lootPool;

		public LootTableInsert(FabricLootPoolBuilder lootPool, Identifier... tables) {
			this.tables = tables;
			this.lootPool = lootPool;
		}

		public void insert(FabricLootSupplierBuilder supplier) {
			supplier.pool(lootPool);
		}
	}
}