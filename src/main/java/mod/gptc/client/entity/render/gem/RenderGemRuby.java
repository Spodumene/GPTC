package mod.gptc.client.entity.render.gem;

import mod.gptc.client.entity.model.gem.ModelRuby;
import mod.gptc.client.entity.render.gem.ruby.RubyGemFeature;
import mod.gptc.client.entity.render.gem.ruby.RubyHairFeature;
import mod.gptc.client.entity.render.gem.ruby.RubyInsigniaFeature;
import mod.gptc.client.entity.render.gem.ruby.RubySkinFeature;
import mod.gptc.client.entity.render.gem.ruby.RubyUniformFeature;
import mod.gptc.entity.gem.GemRuby;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class RenderGemRuby extends GeoEntityRenderer<GemRuby> implements IGeoRenderer<GemRuby> {
	public RenderGemRuby(Context context) {
		super(context, new ModelRuby());
		this.addLayer(new RubySkinFeature(this));
		this.addLayer(new RubyHairFeature(this));
		this.addLayer(new RubyUniformFeature(this));
		this.addLayer(new RubyInsigniaFeature(this));
		this.addLayer(new RubyGemFeature(this));
	}
	
	@Override
	public Identifier getTexture(GemRuby entity) {
		return new Identifier("gptc:textures/entities/ruby/ruby.png");
	}
}