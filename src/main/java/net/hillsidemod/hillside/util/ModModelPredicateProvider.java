package net.hillsidemod.hillside.util;

import net.hillsidemod.hillside.item.ModItems;
import net.hillsidemod.hillside.item.custom.EndMirrorItem;
import net.hillsidemod.hillside.item.custom.FoxCageItem;
import net.hillsidemod.hillside.item.custom.NetherMirrorItem;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {

    public static void init()
    {
        registerMirror(ModItems.MIRROR);
        //registerNetherMirror(ModItems.NETHER_MIRROR);
        registerNetherHasBlock(ModItems.NETHER_MIRROR);
        //registerEndMirror(ModItems.END_MIRROR);
        registerEndHasBlock(ModItems.END_MIRROR);
        registerFoxCageTexture(ModItems.BUCKET_FOX);
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
         /*private static void registerNetherMirror(Item netherMirrorItem) {
            ModelPredicateProviderRegistry.register(netherMirrorItem,new Identifier("nether_charging"),
                (stack, world, entity, seed) -> {

                    if(entity==null || entity.getActiveItem() != stack)
                        return 0.0f;
                    else
                    {
                        if(entity.getItemUseTimeLeft()>10 && entity.getItemUseTimeLeft()<20)
                            return 1.0f;
                        else if(entity.getItemUseTimeLeft()>30 && entity.getItemUseTimeLeft()<40)
                            return 1.0f;
                    }
                    return 0.0f;
                });
            }*/

            private static void registerNetherHasBlock(Item netherMirrorItem)
            {
                ModelPredicateProviderRegistry.register(netherMirrorItem,new Identifier("nether_block"),
                        (stack, world, entity, seed) ->
                        {
                            float check = ((NetherMirrorItem) netherMirrorItem).setItemTexture(stack);
                            if (check == 0.0f)
                                return 0.0f;
                            else if (check == 0.5f)
                            {
                                if (entity.getItemUseTimeLeft() > 10 && entity.getItemUseTimeLeft() < 20)
                                    return 0.5f;
                                else if (entity.getItemUseTimeLeft() > 30 && entity.getItemUseTimeLeft() < 40)
                                    return 0.0f;
                            }
                            else
                                return 1.0f;
                            return 0.0f;
                        });
            }

    private static void registerEndMirror(Item endMirrorItem) {
        ModelPredicateProviderRegistry.register(endMirrorItem,new Identifier("end_charging"),
                (stack, world, entity, seed) -> {

                    if(entity==null || entity.getActiveItem() != stack)
                        return 0.0f;
                    else
                    {
                        if(entity.getItemUseTimeLeft()>10 && entity.getItemUseTimeLeft()<20)
                            return 1.0f;
                        else if(entity.getItemUseTimeLeft()>30 && entity.getItemUseTimeLeft()<40)
                            return 1.0f;
                    }
                    return 0.0f;
                });
    }
    private static void registerEndHasBlock(Item endMirrorItem)
    {
        ModelPredicateProviderRegistry.register(endMirrorItem,new Identifier("end_block"),
                (stack, world, entity, seed) ->
                {
                    float check = ((EndMirrorItem) endMirrorItem).setItemTexture(stack);
                    if (check == 0.0f)
                        return 0.0f;
                    else if (check == 0.5f)
                    {
                        if (entity.getItemUseTimeLeft() > 10 && entity.getItemUseTimeLeft() < 20)
                            return 0.5f;
                        else if (entity.getItemUseTimeLeft() > 30 && entity.getItemUseTimeLeft() < 40)
                            return 0.0f;
                    }
                    else
                        return 1.0f;
                    return 0.0f;
                });
    }

    private static void registerFoxCageTexture(Item foxCage)
    {
        ModelPredicateProviderRegistry.register(foxCage, new Identifier("fox_entity"),
                (stack, world, entity, seed) ->
                {
                    float foxVar = ((FoxCageItem)foxCage).setItemTexture(stack);

                    if(foxVar==1)
                        return 0.0f;
                    else if(foxVar==2)
                        return 0.5f;
                    else
                        return 1.0f;
                });

    }
}

