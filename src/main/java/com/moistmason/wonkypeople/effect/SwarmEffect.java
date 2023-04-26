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
    }

    public void spawnBees(LivingEntity entity, double posX, double posY, double posZ) {
        ServerLevel level = (ServerLevel) entity.getLevel();

        // iterate through random amount of bees and spawn them. Is there a cleaner way to do this?
        int[] amount = new int[getRandomBeeAmount()];
        for (int i = 0; i < amount.length; i++) {
            Bee bee = new Bee(EntityType.BEE, level);
            level.addFreshEntity(bee);
            bee.setPos(getRandomPos(posX), posY, getRandomPos(posZ));
            bee.isAngry();
            bee.setPersistentAngerTarget(entity.getUUID());
        }
    }

    public int getRandomBeeAmount() {
        Random random = new Random();
        return random.nextInt(2, 5);
    }

    public double getRandomPos(double position) {
        Random randRadius = new Random();
        return position + randRadius.nextDouble(2, 5);
    }
}
