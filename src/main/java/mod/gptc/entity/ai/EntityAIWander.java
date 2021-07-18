package mod.gptc.entity.ai;

import mod.gptc.entity.GemEntity;
import net.minecraft.entity.ai.goal.WanderAroundGoal;

public class EntityAIWander extends WanderAroundGoal {
    public GemEntity gem;

    public EntityAIWander(GemEntity creatureIn, double speedIn) {
        super(creatureIn, speedIn);
        this.gem = creatureIn;
    }

    public boolean canStart() {
        return this.gem.getMovementType() == 1 && super.canStart();
    }

    public boolean shouldContinue() {
        return this.gem.getMovementType() == 1 && super.shouldContinue() && !this.gem.getNavigation().isFollowingPath() == false;
    }
}