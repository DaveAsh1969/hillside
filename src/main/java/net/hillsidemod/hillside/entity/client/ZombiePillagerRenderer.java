package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.custom.DecayingZombieEntity;
import net.hillsidemod.hillside.entity.custom.ZombiePillagerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ZombiePillagerRenderer extends GeoEntityRenderer<ZombiePillagerEntity>
{
    public ZombiePillagerRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ZombiePillagerModel());
    }

    @Override
    public Identifier getTextureLocation(ZombiePillagerEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "textures/entity/zombie_pillager.png");
    }

    @Override
    public void render(ZombiePillagerEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby())
        {
            poseStack.scale(0.65f, 0.6f, 0.65f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
