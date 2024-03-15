package net.hillsidemod.hillside.block.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.block.entity.FoxBlockEntity;
import net.hillsidemod.hillside.block.entity.TacoBellBlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class FoxBlockEntityRenderer extends GeoBlockRenderer<FoxBlockEntity> {

    public FoxBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        super(new FoxBlockEntityModel());
    }

    @Override
    public Identifier getTextureLocation(FoxBlockEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "textures/block/fox_cage.png");
    }

    @Override
    public RenderLayer getRenderType(FoxBlockEntity animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
