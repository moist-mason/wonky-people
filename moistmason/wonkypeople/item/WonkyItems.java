package com.moistmason.wonkypeople.item;

import com.moistmason.wonkypeople.WonkyPeople;
import com.moistmason.wonkypeople.entity.WonkyEntityTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;

public class WonkyItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WonkyPeople.MODID);

    public static final RegistryObject<SpawnEggItem> WONKY_PERSON_SPAWN_EGG = ITEMS.register("wonky_person_spawn_egg", () ->
            new ForgeSpawnEggItem(WonkyEntityTypes.WONKY_PERSON, 0x000000, 0xFFFFFF, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> HAPPY_WONKY_SPAWN_EGG = ITEMS.register("happy_wonky_spawn_egg", () ->
            new ForgeSpawnEggItem(WonkyEntityTypes.HAPPY_WONKY, 0x000000, 0xFF0000, new Item.Properties()));
}
