package mod.gptc.client.entity.model.gem;

import mod.gptc.entity.gem.GemRuby;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;

@Environment(EnvType.CLIENT)
public class ModelRuby extends BipedEntityModel<GemRuby> {

    public ModelRuby(ModelPart modelPart) {
    	super(modelPart);
    }
    
    public static TexturedModelData getTexturedModelData() {
    	ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, -14.0F);
    	ModelPartData modelPartData = modelData.getRoot();
        ModelTransform modelTransform = ModelTransform.pivot(0.0F, -13.0F, 0.0F);
        modelPartData.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create().uv(59, 0).cuboid(-4.0F, -8.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.5F)), modelTransform);
    	modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(32, 20).cuboid(0F, 23F, 0F, 8.0F, 9.0F, 5.0F), ModelTransform.pivot(-2.0F, 12.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-5F, 11F, -3F, 14.0F, 11.0F, 9.0F), modelTransform);
        modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(16, 20).cuboid(1F, 21F, 0F, 4.0F, 8.0F, 4.0F), ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(0, 20).cuboid(-1F, 21F, 0F, 4.0F, 8.0F, 4.0F), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(0, 32).cuboid(0F, 23F, 0F, 4.0F, 6.0F, 4.0F), ModelTransform.pivot(2.0F, 9.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(16, 32).cuboid(0F, 23F, 0F, 4.0F, 6.0F, 4.0F), ModelTransform.pivot(-2.0F, 9.0F, 0.0F));
    	return TexturedModelData.of(modelData, 64, 42);
    }

    public void setAngles(GemRuby livingEntity, float f, float g, float h, float i, float j) {
        super.setAngles(livingEntity, f, g, h, i, j);
        this.head.visible = true;
        this.body.pitch = 0.0F;
        this.body.pivotY = -14.0F;
        this.body.pivotZ = -0.0F;
        ModelPart var10000 = this.rightLeg;
        var10000.pitch -= 0.0F;
        var10000 = this.leftLeg;
        var10000.pitch -= 0.0F;
        var10000 = this.rightArm;
        var10000.pitch = (float)((double)var10000.pitch * 0.5D);
        var10000 = this.leftArm;
        var10000.pitch = (float)((double)var10000.pitch * 0.5D);
        var10000 = this.rightLeg;
        var10000.pitch = (float)((double)var10000.pitch * 0.5D);
        var10000 = this.leftLeg;
        var10000.pitch = (float)((double)var10000.pitch * 0.5D);
        if (this.rightArm.pitch > 0.4F) {
           this.rightArm.pitch = 0.4F;
        }

        if (this.leftArm.pitch > 0.4F) {
           this.leftArm.pitch = 0.4F;
        }

        if (this.rightArm.pitch < -0.4F) {
           this.rightArm.pitch = -0.4F;
        }

        if (this.leftArm.pitch < -0.4F) {
           this.leftArm.pitch = -0.4F;
        }

        if (this.rightLeg.pitch > 0.4F) {
           this.rightLeg.pitch = 0.4F;
        }

        if (this.leftLeg.pitch > 0.4F) {
           this.leftLeg.pitch = 0.4F;
        }

        if (this.rightLeg.pitch < -0.4F) {
           this.rightLeg.pitch = -0.4F;
        }

        if (this.leftLeg.pitch < -0.4F) {
           this.leftLeg.pitch = -0.4F;
        }

        this.rightLeg.pivotZ = 0.0F;
        this.leftLeg.pivotZ = 0.0F;
        this.rightLeg.pivotY = -5.0F;
        this.leftLeg.pivotY = -5.0F;
        this.head.pivotZ = -0.0F;
        this.head.pivotY = -13.0F;
        this.rightArm.setPivot(-5.0F, -12.0F, 0.0F);
        this.leftArm.setPivot(5.0F, -12.0F, 0.0F);
     }
}