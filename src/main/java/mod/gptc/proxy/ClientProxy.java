package mod.gptc.proxy;

import mod.gptc.client.entity.render.gem.RenderGemRuby;
import mod.gptc.init.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class ClientProxy implements ClientModInitializer {
	public static final EntityModelLayer MODEL_RUBY_LAYER = new EntityModelLayer(new Identifier("gptc", "ruby"), "main");
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.INSTANCE.register(ModEntities.RUBY, (context) -> new RenderGemRuby(context));
	}
}
