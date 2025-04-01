package main.entities.enemies;

import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import main.scene.GameScene;

import java.util.ArrayList;

public class EnemySpawnTimer extends Timer {

    private final ArrayList<IEnemy> enemies;
    private int currentIndex = 0;

    public EnemySpawnTimer(long intervalInMs, ArrayList<IEnemy> enemies) {
        super(intervalInMs);
        this.enemies = enemies;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        if (currentIndex < enemies.size()) {
            GameScene.getInstance().addNewEntity((YaegerEntity) enemies.get(currentIndex));
            currentIndex++;
        }
    }
}
