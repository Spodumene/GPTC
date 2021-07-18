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
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class LayerRubyInsignia extends FeatureRenderer<GemRuby, ModelRuby> {
	private static final Identifier INSIG = new Identifier("gptc:textures/entities/ruby/insignia.png");
	public LayerRubyInsignia(FeatureRendererContext<GemRuby, ModelRuby> context) {
		super(context);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, GemRuby entity,
			float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw,
			float headPitch) {
	    float v;
	    float w;
	    float x;
	    float[] hs = SheepEntity.getRgbColor(DyeColor.values()[entity.getInsigniaColor()]);
	    v = hs[0];
	    w = hs[1];
	    x = hs[2];
        VertexConsumer builder = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(INSIG));
        this.getContextModel().render(matrices, builder, light, OverlayTexture.DEFAULT_UV, v, w, x, 1.0F);
	}
}
