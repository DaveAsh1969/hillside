package net.hillsidemod.hillside.block.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.block.entity.TrollHeadEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TrollHeadModel extends GeoModel<TrollHeadEntity> {
    @Override
    public Identifier getModelResource(TrollHeadEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "geo/troll_head.geo.json");
    }

    @Override
    public Identifier getTextureResource(TrollHeadEntity animatable) {
        return new Identifier(Hillside.MOD_ID, "textures/block/troll_head.png");
    }

    @Override
    public Identifier getAnimationResource(TrollHeadEntity animatable) {
        return null;
    }


}
