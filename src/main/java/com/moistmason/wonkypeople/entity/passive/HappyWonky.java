package com.moistmason.wonkypeople.entity.passive;

import com.moistmason.wonkypeople.entity.WonkyEntityTypes;
import com.moistmason.wonkypeople.entity.ai.goal.RunInFrontOfPlayerGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;

import java.util.Random;

public class HappyWonky extends Wonky {
    public HappyWonky(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createLivingAttributes().add(Attributes.MAX_HEALTH, 25.00).add(Attributes.MOVEMENT_SPEED, 0.6f)
                .add(Attributes.FOLLOW_RANGE, 20.00).build();
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4, new RunInFrontOfPlayerGoal(this, 2.0F));
    }
}
