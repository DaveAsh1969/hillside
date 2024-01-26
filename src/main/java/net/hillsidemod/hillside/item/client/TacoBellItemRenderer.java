package net.hillsidemod.hillside.item.client;

import net.hillsidemod.hillside.item.custom.TacoBellItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TacoBellItemRenderer extends GeoItemRenderer<TacoBellItem> {
    public TacoBellItemRenderer() {
        super(new TacoBellItemModel());
    }
}