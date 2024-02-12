package net.hillsidemod.hillside.block.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.block.entity.TrollHeadEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TrollHeadRenderer extends GeoBlockRenderer<TrollHeadEntity>
{
    public TrollHeadRenderer(BlockEntityRendererFactory.Context ctx) {
        super(new TrollHeadModel());
    }

    @Override
    public Identifier getTextureLocation(TrollHeadEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "textures/block/taco_bell.png");
    }

    @Override
    public RenderLayer getRenderType(TrollHeadEntity animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
