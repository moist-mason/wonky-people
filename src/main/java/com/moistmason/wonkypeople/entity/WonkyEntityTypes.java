package com.moistmason.wonkypeople.entity;

import com.moistmason.wonkypeople.WonkyPeople;
import com.moistmason.wonkypeople.entity.passive.HappyWonky;
import com.moistmason.wonkypeople.entity.passive.Wonky;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WonkyEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WonkyPeople.MODID);

    public static final RegistryObject<EntityType<Wonky>> WONKY_PERSON = ENTITY_TYPES.register("wonky_person", () ->
            EntityType.Builder.of(Wonky::new, MobCategory.CREATURE).sized(0.6F, 1.95F).build(new ResourceLocation(WonkyPeople.MODID, "wonky_person").toString()));
    public static final RegistryObject<EntityType<HappyWonky>> HAPPY_WONKY = ENTITY_TYPES.register("happy_wonky", () ->
            EntityType.Builder.of(HappyWonky::new, MobCategory.CREATURE).sized(0.6F, 1.95F).build(new ResourceLocation(WonkyPeople.MODID, "happy_wonky").toString()));
}
