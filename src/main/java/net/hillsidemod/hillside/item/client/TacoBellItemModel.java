package net.hillsidemod.hillside.item.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.item.custom.TacoBellItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TacoBellItemModel extends GeoModel<TacoBellItem> {
    @Override
    public Identifier getModelResource(TacoBellItem object) {
        return new Identifier(Hillside.MOD_ID, "geo/taco_bell_item.geo.json");
    }

    @Override
    public Identifier getTextureResource(TacoBellItem object) {
        return new Identifier(Hillside.MOD_ID, "textures/item/taco_bell.png");
    }

    @Override
    public Identifier getAnimationResource(TacoBellItem animatable) {
        return new Identifier(Hillside.MOD_ID, "animations/taco_bell.animation.json");
    }
}
