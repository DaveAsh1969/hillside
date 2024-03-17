package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.custom.DuckEntity;
import net.hillsidemod.hillside.entity.variant.DuckVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

//TODO: getTextureResource should get variant
public class DuckEntityModel extends GeoModel<DuckEntity> {
    @Override
    public Identifier getModelResource(DuckEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "geo/duck.geo.json");
    }

    @Override
    public Identifier getTextureResource(DuckEntity animatable) {
        if(animatable.isBaby())
            return DuckEntityRenderer.LOCATION_BY_VARIANT.get(DuckVariant.BABY);
        else
            return DuckEntityRenderer.LOCATION_BY_VARIANT.get(animatable.getVariant());
    }

    @Override
    public Identifier getAnimationResource(DuckEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "animations/duck.animation.json");
    }

   /* @Override
    public void setCustomAnimations(DuckEntity animatable, long instanceId, AnimationState<DuckEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }*/
}
