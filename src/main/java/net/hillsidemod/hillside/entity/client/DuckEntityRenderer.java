package net.hillsidemod.hillside.entity.client;

import com.google.common.collect.Maps;
import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.custom.DuckEntity;
import net.hillsidemod.hillside.entity.variant.DuckVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class DuckEntityRenderer extends GeoEntityRenderer<DuckEntity> {
    public DuckEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new DuckEntityModel());
    }

    public static final Map<DuckVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(DuckVariant.class), (map) -> {
                map.put(DuckVariant.MALLARD,
                        new Identifier(Hillside.MOD_ID, "textures/entity/duck_mallard.png"));
                map.put(DuckVariant.TAN,
                        new Identifier(Hillside.MOD_ID, "textures/entity/duck_tan.png"));
                map.put(DuckVariant.BLUE,
                        new Identifier(Hillside.MOD_ID, "textures/entity/duck_blue.png"));
                map.put(DuckVariant.BROWN,
                        new Identifier(Hillside.MOD_ID, "textures/entity/duck_brown.png"));
                map.put(DuckVariant.BABY,
                        new Identifier(Hillside.MOD_ID, "textures/entity/duck_baby.png"));
                map.put(DuckVariant.NONE,
                        new Identifier(Hillside.MOD_ID, "textures/entity/duck_baby.png"));
            });
    @Override
    public Identifier getTextureLocation(DuckEntity animatable) {
        if(animatable.isBaby())
            return LOCATION_BY_VARIANT.get(DuckVariant.BABY);
        else
            return LOCATION_BY_VARIANT.get(animatable.getVariant());
        //return new Identifier(Hillside.MOD_ID, "textures/entity/duck_mallard.png");
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
