package net.hillsidemod.hillside.block.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.block.entity.FoxBlockEntity;
import net.hillsidemod.hillside.block.entity.TacoBellBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class FoxBlockEntityModel extends GeoModel<FoxBlockEntity> {
    @Override
    public Identifier getModelResource(FoxBlockEntity object) {
        return new Identifier(Hillside.MOD_ID, "geo/fox_cage.geo.json");
    }

    @Override
    public Identifier getTextureResource(FoxBlockEntity object) {
        return new Identifier(Hillside.MOD_ID, "textures/block/fox_cage.png");
    }

    @Override
    public Identifier getAnimationResource(FoxBlockEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "animations/fox_cage.animation.json");
    }
}
