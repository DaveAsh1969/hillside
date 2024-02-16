package net.hillsidemod.hillside.item.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.item.custom.TrollHeadItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TrollHeadItemModel extends GeoModel<TrollHeadItem> {
    @Override
    public Identifier getModelResource(TrollHeadItem object) {
        return new Identifier(Hillside.MOD_ID, "geo/troll_head.geo.json");
    }

    @Override
    public Identifier getTextureResource(TrollHeadItem object) {
        return new Identifier(Hillside.MOD_ID, "textures/block/troll_head.png");
    }

    @Override
    public Identifier getAnimationResource(TrollHeadItem animatable) {
        return null;
    }
}
