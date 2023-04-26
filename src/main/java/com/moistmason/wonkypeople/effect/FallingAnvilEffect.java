package com.moistmason.wonkypeople.effect;


import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class FallingAnvilEffect extends MobEffect {
    protected FallingAnvilEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.getLevel().isClientSide) {
            double posX = entity.position().x;
            double posY = entity.position().y;
            double posZ = entity.position().z;

            spawnAnvil(entity, posX, posY, posZ);
        }
    }

    public void spawnAnvil(LivingEntity entity, double posX, double posY, double posZ) {
        Level level = entity.getLevel();
        BlockPos pos = new BlockPos((int) posX, (int) (posY + 7), (int) posZ);
        level.setBlockAndUpdate(pos, Blocks.ANVIL.defaultBlockState());
    }
}
