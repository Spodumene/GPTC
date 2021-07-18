package mod.gptc.client.entity.model.gem;

import com.google.common.collect.ImmutableList;

import mod.gptc.entity.gem.GemRuby;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class ModelRuby extends EntityModel<GemRuby> {
    private final ModelPart gemHead;
    private final ModelPart gemBody;
    private final ModelPart gemRightArm;
    private final ModelPart gemLeftArm;
    private final ModelPart gemLeftLeg;
    private final ModelPart gemRightLeg;

    public ModelRuby(ModelPart modelPart) {
    	super();
    	this.gemHead = modelPart.getChild(EntityModelPartNames.HEAD);
    	this.gemBody = modelPart.getChild(EntityModelPartNames.BODY);
    	this.gemRightArm = modelPart.getChild(EntityModelPartNames.RIGHT_ARM);
    	this.gemLeftArm = modelPart.getChild(EntityModelPartNames.LEFT_ARM);
    	this.gemLeftLeg = modelPart.getChild(EntityModelPartNames.LEFT_LEG);
    	this.gemRightLeg = modelPart.getChild(EntityModelPartNames.RIGHT_LEG);
    }
    
    public static TexturedModelData getTexturedModelData() {
    	ModelData modelData = new ModelData();
    	ModelPartData modelPartData = modelData.getRoot();
    	modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(32, 20).cuboid(-2F, -4F, -2.5F, 8.0F, 9.0F, 5.0F), ModelTransform.pivot(-2.0F, 12.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -3.0F, -4.5F, 14.0F, 11.0F, 9.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(16, 20).cuboid(4F, 8.0F, -2.0F, 4.0F, 8.0F, 4.0F), ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(0, 20).cuboid(-8F, 8.0F, -2.0F, 4.0F, 8.0F, 4.0F), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(0, 32).cuboid(-4.0F, 17.0F, -2.0F, 4.0F, 6.0F, 4.0F), ModelTransform.pivot(2.0F, 9.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(16, 32).cuboid(0.0F, 17.0F, -2.0F, 4.0F, 6.0F, 4.0F), ModelTransform.pivot(-2.0F, 9.0F, 0.0F));
    	return TexturedModelData.of(modelData, 64, 42);
    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.gemLeftArm, this.gemLeftLeg, this.gemRightLeg, this.gemBody, this.gemRightArm, this.gemHead).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setAngles(GemRuby entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.gemHead, headPitch * 0.9f * ((float)Math.PI / 180F), netHeadYaw * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.gemLeftArm, 0, 0, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * 1.5F * limbSwingAmount * 0.8f);
       this.setRotateAngle(this.gemRightArm, 0, 0, MathHelper.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount * 0.8f);
       this.setRotateAngle(this.gemLeftLeg, 0, 0, MathHelper.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount * 0.8f);
       this.setRotateAngle(this.gemRightLeg, 0, 0, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * 1.5F * limbSwingAmount * 0.8f);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.pivotX = x;
        modelRenderer.pivotY = y;
        modelRenderer.pivotZ = z;
    }
}