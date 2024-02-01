package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.custom.DuckEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DuckEntityRenderer extends GeoEntityRenderer<DuckEntity> {
    public DuckEntityRenderer(EntityRendererFactory.Context renderManager, GeoModel<DuckEntity> model) {
        super(renderManager, model);
    }

    @Override
    public Identifier getTextureLocation(DuckEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "textures/entity/duck.png");
    }

    @Override
    public void render(DuckEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby())
        {
            poseStack.scale(0.65f, 0.6f, 0.65f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
