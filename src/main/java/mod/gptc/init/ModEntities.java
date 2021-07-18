package mod.gptc.init;

import java.util.HashMap;

import mod.gptc.entity.GemEntity;
import mod.gptc.entity.gem.GemRuby;
import net.fabricmc.fabric.api.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("deprecation")
public class ModEntities {
	public static final HashMap<String, Class<? extends GemEntity>> GEMS = new HashMap<String, Class<? extends GemEntity>>();
	public static final EntityType<GemRuby> RUBY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("gptc", "ruby"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GemRuby::new).size(EntityDimensions.fixed(1.5f, 1.5f)).build()
    );

	public static void registerEntities() {
		FabricDefaultAttributeRegistry.register(RUBY, GemRuby.createMobAttributes());
	}
}
