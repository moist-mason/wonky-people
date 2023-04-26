package com.moistmason.wonkypeople.effect;

import com.moistmason.wonkypeople.WonkyPeople;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WonkyEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, WonkyPeople.MODID);

    public static final RegistryObject<MobEffect> SWARM = MOB_EFFECTS.register("swarm", () -> new SwarmEffect(MobEffectCategory.HARMFUL, 0xFFFF00));
    public static final RegistryObject<MobEffect> FALLING_ANVIL = MOB_EFFECTS.register("falling_anvil", () -> new FallingAnvilEffect(MobEffectCategory.HARMFUL, 0xCCCCCC));

    public static MobEffect getRandomWonkyEffect() {
        List<MobEffect> list = getEffectList();
        Random random = new Random();
        int value = random.nextInt(list.size());
        return list.get(value);
    }

    public static List<MobEffect> getEffectList() {
        List<MobEffect> list = new ArrayList<>();
        list.add(SWARM.get());
        list.add(FALLING_ANVIL.get());

        return list;
    }
}
