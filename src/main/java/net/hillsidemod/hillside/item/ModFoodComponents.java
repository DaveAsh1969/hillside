package net.hillsidemod.hillside.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent CHEESE = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.2f)
            .build();
    public static final FoodComponent DECAYING_FLESH = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.8f).meat().build();
    public static final FoodComponent DUCK_RAW = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3f).meat().build();
    public static final FoodComponent DUCK_COOKED = new FoodComponent.Builder().hunger(7).saturationModifier(0.7f).meat().build();
    public static final FoodComponent LETTUCE = (new FoodComponent.Builder())
            .hunger(4)
            .saturationModifier(0.4f)
            .build();
    public static final FoodComponent TACO = (new FoodComponent.Builder()).hunger(6).saturationModifier(0.9f).meat()
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 80, 1), 1.0f)
            .alwaysEdible()
            .build();
    public static final FoodComponent TORTILLA = (new FoodComponent.Builder())
            .hunger(7)
            .saturationModifier(0.4f)
            .build();
}
