package mod.gptc.client.entity.model.gem;

import mod.gptc.entity.gem.GemRuby;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

@Environment(EnvType.CLIENT)
public class ModelRuby extends AnimatedGeoModel<GemRuby> {
	
	@Override
	public Identifier getAnimationFileLocation(GemRuby animatable) {
		return new Identifier("gptc:animations/entities/ruby.animations.json");
	}

	@Override
	public Identifier getModelLocation(GemRuby object) {
		return new Identifier("gptc:geo/entities/ruby.geo.json");
	}

	@Override
	public Identifier getTextureLocation(GemRuby object) {
		return new Identifier("gptc:textures/entities/ruby/ruby.png");
	}
}