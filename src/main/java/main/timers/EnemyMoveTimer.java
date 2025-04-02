package main.timers;

import com.github.hanyaeger.api.Timer;
import main.entities.enemies.Enemy;

public class EnemyMoveTimer extends Timer {

    private final Enemy enemy;

    public EnemyMoveTimer(Enemy enemy, int interval) {
        super(interval);
        this.enemy = enemy;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        enemy.moveEnemy();
    }

}
