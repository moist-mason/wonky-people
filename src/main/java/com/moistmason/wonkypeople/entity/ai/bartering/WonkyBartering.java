package com.moistmason.wonkypeople.entity.ai.bartering;

import com.moistmason.wonkypeople.WonkyPeople;
import com.moistmason.wonkypeople.entity.passive.EmotionalWonky;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.List;

/**
 * Wonkys can be bartered with, much like piglins.
 * This class acts as a simplified version of pigling bartering, containing many similar concepts as what's found in the vanilla code.
 */
public class WonkyBartering {
    public static boolean inspecting = false;

    public static void barter(EmotionalWonky wonky, InteractionHand hand, List<ItemEntity> items) {
        items.forEach(item -> {
            walkTowards(wonky, item);
            pickup(wonky, item, hand);
            if (wonky.getCurrencies().contains(item.getItem().getItem())) {
                reward(wonky);
            } else {
                BehaviorUtils.throwItem(wonky, item.getItem(), wonky.position().add(0, 1, 0));
            }
        });
    }

    public static void walkTowards(EmotionalWonky wonky, ItemEntity item) {
        wonky.getLookAngle().add(item.position());
        wonky.getNavigation().moveTo(item.getX(), item.getY(), item.getZ(), wonky.getSpeed() * 0.5);
    }

    public static void pickup(EmotionalWonky wonky, ItemEntity itemEntity, InteractionHand hand) {
        ItemStack item = itemEntity.getItem();
        wonky.setItemInHand(hand, item);
        inspecting = true;
        itemEntity.discard();
    }

    public static void reward(EmotionalWonky wonky) {
        inspecting = false;
        wonky.getItemInHand(wonky.getUsedItemHand()).setCount(0);
        LootTable table = wonky.level.getServer().getLootTables().get(getBarterLootResource(wonky));
        ObjectArrayList<ItemStack> items = table.getRandomItems(getLootContext(wonky));
        items.forEach(item -> BehaviorUtils.throwItem(wonky, item, wonky.position().add(0, 1, 0)));
    }

    public static ResourceLocation getBarterLootResource(EmotionalWonky wonky) {
        String name = wonky.getName().getString();
        return new ResourceLocation(WonkyPeople.MODID, "loot_tables/entities/" + name + "_bartering");
    }

    public static LootContext getLootContext(EmotionalWonky wonky) {
        return new LootContext.Builder((ServerLevel) wonky.level)
                .withParameter(LootContextParams.THIS_ENTITY, wonky)
                .withRandom(wonky.level.random)
                .create(LootContextParamSets.PIGLIN_BARTER);
    }
}
