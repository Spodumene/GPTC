package mod.gptc.entity.ai;

import java.util.EnumSet;

import mod.gptc.entity.GemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TrackTargetGoal;

public class EntityAIAttack extends TrackTargetGoal {
    private final GemEntity mob;
    private LivingEntity target;
    private int cooldown;

    public EntityAIAttack(GemEntity mob) {
       super(mob, false);
       this.mob = mob;
       this.setControls(EnumSet.of(Goal.Control.TARGET));
    }

    public boolean canStart() {
       LivingEntity livingEntity = this.mob.getOwner();
       if (livingEntity == null) {
    	   return false;
       }
       if (this.mob.getOwned() && this.mob.getMovementType() != 0 && this.mob.getMovementType() != 3) {
         this.target = livingEntity.getAttacking();
         int i = livingEntity.getLastAttackTime();
         return i != this.cooldown && this.canTrack(this.target, TargetPredicate.DEFAULT);
       } else {
         return false;
       }
    }

  public void start() {
     this.mob.setTarget(this.target);
     LivingEntity livingEntity = this.mob.getOwner();
     if (livingEntity != null) {
      this.cooldown = livingEntity.getLastAttackTime();
     }
     super.start();
  }
}