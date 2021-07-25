package mod.gptc.client.entity.render.gem.ruby;

import mod.gptc.entity.gem.GemRuby;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.provider.GeoModelProvider;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;
import software.bernie.geckolib3.util.AnimationUtils;

@Environment(EnvType.CLIENT)
public class RubyUniformFeature extends GeoLayerRenderer<GemRuby> {
	private static final Identifier UNI = new Identifier("gptc:textures/entities/ruby/uniform.png");
	float red;
	float green;
	float blue;
	public RubyUniformFeature(IGeoRenderer<GemRuby> context) {
		super(context);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn,
			GemRuby entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks,
			float netHeadYaw, float headPitch) {
		GeoModelProvider<GemRuby> modelProviderIn = this.getEntityModel();
		GeoModel model = modelProviderIn.getModel(modelProviderIn.getModelLocation(entitylivingbaseIn));
		IGeoRenderer<GemRuby> renderer = (IGeoRenderer<GemRuby>) AnimationUtils.getRenderer(entitylivingbaseIn);
		RenderLayer renderType = getRenderType(UNI);
		VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderLayer.getEntityCutout(UNI));
        int uni = entitylivingbaseIn.getUniformColor();
        float red = ((uni & 16711680) >> 16) / 255f;
        this.red = red;
        float green = ((uni & 65280) >> 8) / 255f;
        this.green = green;
        float blue = ((uni & 255) >> 0) / 255f;
        this.blue = blue;
		renderer.render(model, entitylivingbaseIn, partialTicks, renderType, matrixStackIn, bufferIn, ivertexbuilder,
				packedLightIn, LivingEntityRenderer.getOverlay(entitylivingbaseIn, 0.0F), this.red, this.green, this.blue, 1.0F);
	}
}