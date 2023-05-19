package com.moistmason.wonkypeople.effect;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class FallingAnvilEffect extends MobEffect {
    protected FallingAnvilEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
        if (!entity.getLevel().isClientSide) {
            entity.setDeltaMovement(0, 0, 0);
            spawnAnvil(entity);
        }
        super.applyInstantenousEffect(source, indirectSource, entity, amplifier, health);
    }

    public void spawnAnvil(LivingEntity entity) {
        ServerLevel level = (ServerLevel) entity.getLevel();
        BlockPos pos = new BlockPos(entity.getBlockX(), entity.getBlockY() + 7, entity.getBlockZ());
        level.setBlockAndUpdate(pos, Blocks.ANVIL.defaultBlockState());
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }
}
