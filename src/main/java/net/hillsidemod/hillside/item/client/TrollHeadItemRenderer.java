package net.hillsidemod.hillside.item.client;

import net.hillsidemod.hillside.item.custom.TrollHeadItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TrollHeadItemRenderer extends GeoItemRenderer<TrollHeadItem> {
    public TrollHeadItemRenderer() {
        super(new TrollHeadItemModel());
    }
}