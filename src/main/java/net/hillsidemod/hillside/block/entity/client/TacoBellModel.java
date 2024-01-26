package net.hillsidemod.hillside.block.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.block.entity.TacoBellBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TacoBellModel extends GeoModel<TacoBellBlockEntity> {
    @Override
    public Identifier getModelResource(TacoBellBlockEntity object) {
        return new Identifier(Hillside.MOD_ID, "geo/taco_bell.geo.json");
    }

    @Override
    public Identifier getTextureResource(TacoBellBlockEntity object) {
        return new Identifier(Hillside.MOD_ID, "textures/block/taco_bell.png");
    }

    @Override
    public Identifier getAnimationResource(TacoBellBlockEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "animations/taco_bell.animation.json");
    }
}
