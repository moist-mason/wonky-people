package com.moistmason.wonkypeople.effect;

import com.moistmason.wonkypeople.item.food.WonkyFoods;
import com.moistmason.wonkypeople.WonkyPeople;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WonkyEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, WonkyPeople.MODID);

    public static final RegistryObject<MobEffect> SWARM = MOB_EFFECTS.register("swarm", () -> new SwarmEffect(MobEffectCategory.HARMFUL, 0xFFFF00));
    public static final RegistryObject<MobEffect> FALLING_ANVIL = MOB_EFFECTS.register("falling_anvil", () -> new FallingAnvilEffect(MobEffectCategory.HARMFUL, 0xCCCCCC));

    /**
     * Gets a random effect from the registered Wonky effects. Used during the consumption of Happy Chicken.
     * @return The random effect selected from the list.
     * @see WonkyFoods#HAPPY_CHICKEN
     */
    public static MobEffect getRandomWonkyEffect() {
        List<MobEffect> list = getEffectList();
        Random random = new Random();
        int value = random.nextInt(list.size());
        return list.get(value);
    }

    /**
     * Gets a list of all the registered effects within the mod.
     * @return The list of effects.
     */
    public static List<MobEffect> getEffectList() {
        return MOB_EFFECTS.getEntries().stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
    }
}
