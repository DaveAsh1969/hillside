package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.custom.ChristmasTreeEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ChristmasTreeRenderer extends LivingEntityRenderer<ChristmasTreeEntity, ChristmasTreeModel<ChristmasTreeEntity>> {
    private static final Identifier TEXTURE = new Identifier(Hillside.MOD_ID, "textures/entity/christmas_tree.png");
    public ChristmasTreeRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ChristmasTreeModel<>(ctx.getPart(ModModelLayers.CHRISTMAS_TREE)), 0.0f);
    }

    @Override
    public Identifier getTexture(ChristmasTreeEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(ChristmasTreeEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
