package com.moistmason.wonkypeople;

import com.moistmason.wonkypeople.entity.WonkyEntityTypes;
import com.moistmason.wonkypeople.item.WonkyItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import org.slf4j.Logger;

public class WonkyPeople {
    public static final String MODID = "wonkypeople";
    public static final Logger LOGGER = LogUtils.getLogger();

    public WonkyPeople() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::commonSetup);

        DeferredRegister<?>[] registers = {
                WonkyEntityTypes.ENTITY_TYPES,
                WonkyItems.ITEMS
        };

        for (DeferredRegister<?> register : registers) {
            register.register(eventBus);
        }
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(WonkyEntityTypes.WONKY_PERSON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(WonkyEntityTypes.HAPPY_WONKY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
        });
    }
}
