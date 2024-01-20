package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.custom.DecayingZombieEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DecayingZombieRenderer extends GeoEntityRenderer<DecayingZombieEntity>
{
    public DecayingZombieRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new DecayingZombieModel());
    }

    @Override
    public Identifier getTextureLocation(DecayingZombieEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "textures/entity/decaying_zombie.png");
    }

    @Override
    public void render(DecayingZombieEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby())
        {
            poseStack.scale(0.65f, 0.6f, 0.65f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
