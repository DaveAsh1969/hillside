package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.custom.TrollEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TrollRenderer extends GeoEntityRenderer<TrollEntity> {
    public TrollRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new TrollModel());
    }
    @Override
    public Identifier getTextureLocation(TrollEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "textures/entity/troll.png");
    }

    @Override
    public void render(TrollEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {

            poseStack.scale(2.0f, 2.0f, 2.0f);

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
