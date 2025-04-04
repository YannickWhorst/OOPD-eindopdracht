package main.timers;

import com.github.hanyaeger.api.Timer;
import main.entities.enemies.Enemy;
import main.scene.GameScene;

import java.util.ArrayList;

public class EnemySpawnTimer extends Timer {
    private final ArrayList<Enemy> enemies;
    private int currentIndex = 0;

    public EnemySpawnTimer(long intervalInMs, ArrayList<Enemy> enemies) {
        super(intervalInMs);
        this.enemies = enemies;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        if (currentIndex < enemies.size()) {
            GameScene.getInstance().addNewEntity(enemies.get(currentIndex));
            GameScene.getInstance().enemySpawned();
            currentIndex++;
        }
    }
}
