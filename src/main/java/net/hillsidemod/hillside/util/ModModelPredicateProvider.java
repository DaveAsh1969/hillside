package net.hillsidemod.hillside.util;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.hillsidemod.hillside.item.custom.MirrorItem;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
    private static void registerMirror(MirrorItem mirrorItem) {

         /*FabricModelPredicateProviderRegistry.register(mirrorItem, new Identifier("charging"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getActiveItem() == stack ? 1.0f : 0.0f);*/
        ModelPredicateProviderRegistry.register(mirrorItem,new Identifier("charging"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getActiveItem() == stack ? 1.0f : 0.0f);
    }
}
