package net.hillsidemod.hillside.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CHEESE = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.9f)
            .alwaysEdible()
            .build();
    public static final FoodComponent TACO = (new FoodComponent.Builder()).hunger(6).saturationModifier(0.9f).meat()
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200, 1), 1.0f)
            .alwaysEdible()
            .build();
}
