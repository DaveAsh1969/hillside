package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer CHRISTMAS_TREE =
            new EntityModelLayer(new Identifier(Hillside.MOD_ID, "christmas_tree"), "main");
}
