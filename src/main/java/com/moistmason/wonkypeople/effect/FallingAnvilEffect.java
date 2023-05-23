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
        entity.setDeltaMovement(0, 0, 0);
        spawnAnvil(entity);
        super.applyEffectTick(entity, amplifier);
    }

    public void spawnAnvil(LivingEntity entity) {
        Level level = entity.getLevel();
        BlockPos pos = new BlockPos(entity.getBlockX(), entity.getBlockY() + 7, entity.getBlockZ());
        level.setBlockAndUpdate(pos, Blocks.ANVIL.defaultBlockState());
    }

    public boolean isInstantenous() {
        return true;
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration == 1;
    }
}
