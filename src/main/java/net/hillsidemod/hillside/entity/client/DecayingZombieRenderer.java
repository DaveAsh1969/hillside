package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.custom.DecayingZombieEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DecayingZombieRenderer extends MobEntityRenderer <DecayingZombieEntity, DecayingZombieModel<DecayingZombieEntity>> {
    private static final Identifier TEXTURE = new Identifier(Hillside.MOD_ID, "textures/entity/decaying_zombie.png");

    public DecayingZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new DecayingZombieModel<>(context.getPart(ModModelLayers.DECAYING_ZOMBIE)), 0.6f);
    }

    @Override
    public Identifier getTexture(DecayingZombieEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(DecayingZombieEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
