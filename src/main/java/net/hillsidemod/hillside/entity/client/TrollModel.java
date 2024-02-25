package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.custom.TrollEntity;
import net.hillsidemod.hillside.entity.custom.ZombiePillagerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TrollModel extends GeoModel<TrollEntity> {

    @Override
    public Identifier getModelResource(TrollEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "geo/troll.geo.json");
    }

    @Override
    public Identifier getTextureResource(TrollEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "textures/entity/troll.png");
    }

    @Override
    public Identifier getAnimationResource(TrollEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "animations/troll.animation.json");
    }

    @Override
    public void setCustomAnimations(TrollEntity animatable, long instanceId, AnimationState<TrollEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
