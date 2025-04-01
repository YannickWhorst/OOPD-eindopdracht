package main.entities.enemies;

import com.github.hanyaeger.api.Timer;

public class EnemyMoveTimer extends Timer {

    private IEnemy enemy;

    public EnemyMoveTimer(IEnemy enemy, int interval) {
        super(interval);
        this.enemy = enemy;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        enemy.moveEnemy();
    }

}
