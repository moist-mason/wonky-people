package com.moistmason.wonkypeople.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Bee;

import java.util.Random;

/**
 * "Effect" that spawns bees upon activation.
 */
public class SwarmEffect extends MobEffect {

    protected SwarmEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.getLevel().isClientSide) {
            double posX = entity.position().x;
            double posY = entity.position().y;
            double posZ = entity.position().z;

            spawnBees(entity, posX, posY, posZ);
        }
        super.applyEffectTick(entity, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    /**
     * Spawns a random number of angry bees around the entity with the Swarm effect.
     * @param entity The entity with the effected.
     * @param posX The entity's X position.
     * @param posY The entity's Y position.
     * @param posZ The entity's Z position.
     */
    public void spawnBees(LivingEntity entity, double posX, double posY, double posZ) {
        ServerLevel level = (ServerLevel) entity.getLevel();
        Bee bee = new Bee(EntityType.BEE, level);
        level.addFreshEntity(bee);
        bee.setPos(getRandomOffsetPos(posX), posY, getRandomOffsetPos(posZ));
        bee.isAngryAt(entity);
        bee.setPersistentAngerTarget(entity.getUUID());
        bee.setRemainingPersistentAngerTime(600);
    }

    /**
     * Gets a random offset position from the input value.
     * @param position The original position value to offset from.
     * @return The offset position value.
     */
    public double getRandomOffsetPos(double position) {
        Random randRadius = new Random();
        return position + randRadius.nextDouble(2, 5);
    }
}
