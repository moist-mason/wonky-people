package com.moistmason.wonkypeople.item;

import com.moistmason.wonkypeople.WonkyPeople;
import com.moistmason.wonkypeople.entity.WonkyEntityTypes;
import com.moistmason.wonkypeople.item.food.WonkyFoods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class WonkyItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WonkyPeople.MODID);

    public static final RegistryObject<Item> HAPPY_DUST = registerItem("happy_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HAPPY_CHICKEN = registerItem("happy_chicken", () -> new Item((new Item.Properties().food(WonkyFoods.HAPPY_CHICKEN))));

    public static final RegistryObject<SpawnEggItem> WONKY_PERSON_SPAWN_EGG = registerItem("wonky_person_spawn_egg", () ->
            new ForgeSpawnEggItem(WonkyEntityTypes.WONKY_PERSON, 0x000000, 0xFFFFFF, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> HAPPY_WONKY_SPAWN_EGG = registerItem("happy_wonky_spawn_egg", () ->
            new ForgeSpawnEggItem(WonkyEntityTypes.HAPPY_WONKY, 0x000000, 0xFFFF00, new Item.Properties()));

    public static <I extends Item> RegistryObject<I> registerItem(String name, Supplier<I> item) {
        return ITEMS.register(name, item);
    }

    /**
     * Get all items in the mod, excluding block items.
     * @return The list of all items.
     */
    public static List<Item> getAllItems() {
        return ITEMS.getEntries().stream()
                .filter(item -> !(item.get() instanceof BlockItem))
                .map(RegistryObject::get)
                .collect(Collectors.toList());
    }
}
