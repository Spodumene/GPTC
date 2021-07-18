package mod.gptc.client.entity.render.layers.ruby;

import mod.gptc.client.entity.model.gem.ModelRuby;
import mod.gptc.entity.gem.GemRuby;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class LayerRubyUniform extends FeatureRenderer<GemRuby, ModelRuby> {
	private static final Identifier UNIFORM = new Identifier("gptc:textures/entities/ruby/uniform.png");

	public LayerRubyUniform(FeatureRendererContext<GemRuby, ModelRuby> context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, GemRuby entity,
			float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw,
			float headPitch) {
        int skin = entity.getSkinColor();
        float r = ((skin & 16711680) >> 16) / 255f;
        float g = ((skin & 65280) >> 8) / 255f;
        float b = ((skin & 255) >> 0) / 255f;
        VertexConsumer builder = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(UNIFORM));
        this.getContextModel().render(matrices, builder, light, OverlayTexture.DEFAULT_UV, r, g, b, 1.0F);
	}
}
