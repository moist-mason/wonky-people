package com.moistmason.wonkypeople.entity.passive;

import com.moistmason.wonkypeople.entity.ai.bartering.WonkyBartering;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmotionalWonky extends Wonky {
    public static List<Item> universalCurrencies = new ArrayList<>(Arrays.asList(Items.OXEYE_DAISY, Items.WHITE_WOOL, Items.GRAY_WOOL, Items.WHITE_TULIP));

    public EmotionalWonky(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
    }

    public List<Item> getCurrencies() {
        return universalCurrencies;
    }

    public void aiStep() {
        List<ItemEntity> items = getNearestItemEntities();
        if (!items.isEmpty()) {
            WonkyBartering.barter(this, this.getUsedItemHand(), items);
        }
    }

    public List<ItemEntity> getNearestItemEntities() {
        return this.getLevel().getEntitiesOfClass(ItemEntity.class, this.getBoundingBox().inflate(5));
    }
}
