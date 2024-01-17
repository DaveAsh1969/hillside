package net.hillsidemod.hillside.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.hillsidemod.hillside.item.ModItems;
import net.hillsidemod.hillside.item.custom.MirrorItem;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {

    public static void init()
    {
        registerMirror(ModItems.MIRROR);
    }
    private static void registerMirror(Item mirrorItem) {
       ModelPredicateProviderRegistry.register(mirrorItem,new Identifier("charging"),
               (stack, world, entity, seed) -> {
                    if(entity==null || entity.getActiveItem() != stack)
                        return 0.0f;
                    else
                    {
                        if(entity.getItemUseTimeLeft()>10 && entity.getItemUseTimeLeft()<20)
                            return 1.0f;
                        else if(entity.getItemUseTimeLeft()>30 && entity.getItemUseTimeLeft()<40)
                            return 1.0f;
                        else
                            return 0.0f;
                    }
               });
         }
    }

