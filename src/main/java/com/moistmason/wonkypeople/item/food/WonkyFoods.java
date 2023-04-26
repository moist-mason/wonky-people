package com.moistmason.wonkypeople.item.food;

import com.moistmason.wonkypeople.effect.WonkyEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class WonkyFoods {
    public static final FoodProperties HAPPY_CHICKEN = new FoodProperties.Builder().fast().nutrition(3).saturationMod(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 900, 1), 1.0F)
            .effect(() -> new MobEffectInstance(WonkyEffects.getRandomWonkyEffect(), 500, 1), 0.5F)
            .build();
}
