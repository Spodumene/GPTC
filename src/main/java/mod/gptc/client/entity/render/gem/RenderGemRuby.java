package mod.gptc.client.entity.render.gem;

import mod.gptc.client.entity.model.gem.ModelRuby;
import mod.gptc.client.entity.render.layers.ruby.*;
import mod.gptc.entity.gem.GemRuby;
import mod.gptc.proxy.ClientProxy;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RenderGemRuby extends MobEntityRenderer<GemRuby, ModelRuby> {

	public RenderGemRuby(Context context) {
		super(context, new ModelRuby(context.getPart(ClientProxy.MODEL_RUBY_LAYER)), 1F);
		this.addFeature(new LayerRubySkin(this));
		this.addFeature(new LayerRubyHair(this));
		this.addFeature(new LayerRubyUniform(this));
		this.addFeature(new LayerRubyInsignia(this));
		this.addFeature(new LayerRubyGemstone(this));
	}
	
	@Override
	public Identifier getTexture(GemRuby entity) {
		return new Identifier("gptc:textures/entities/ruby/ruby.png");
	}

}
