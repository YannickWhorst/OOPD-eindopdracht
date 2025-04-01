package main.scene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import main.entities.enemies.EnemySpawnTimer;
import main.entities.enemies.IEnemy;
import main.entities.enemies.regularGoblin.RegularGoblin;
import main.entities.enemies.slowGoblin.SlowGoblin;
import main.entities.hotbar.towerSelectHotbar.TowerSelectHotbar;
import main.entities.map.GameTileMap;
import main.entities.text.HealthText;

import java.util.ArrayList;

public class GameScene extends DynamicScene implements TileMapContainer, TimerContainer {
    private int health = 10;

    private static GameScene instance;

    private GameScene() {
    }

    public static GameScene getInstance() {
        if (instance == null) {
            instance = new GameScene();
        }
        return instance;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var healthText = new HealthText(new Coordinate2D(0, 0));
        healthText.setHealthText(10);
        addEntity(healthText);

        addEntity(new TowerSelectHotbar(new Coordinate2D(getWidth() / 2, getHeight() - 50)));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(GameTileMap.getInstance());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    private Coordinate2D findSpawnTile() {
        int[][] map = GameTileMap.getInstance().defineMap();

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == 99) { // SpawnTile gevonden
                    return new Coordinate2D(x * 40, y * 40); // Return de spawnlocatie als Coordinate2D
                }
            }
        }

        return null; // Geen spawnTile gevonden
    }

    public void addNewEntity(YaegerEntity yaegerEntity) {
        addEntity(yaegerEntity);
    }

    @Override
    public void setupTimers() {
        Coordinate2D spawnTile = findSpawnTile();
        ArrayList<IEnemy> enemies = new ArrayList<>();
        enemies.add(new RegularGoblin(spawnTile));
        enemies.add(new RegularGoblin(spawnTile));
        enemies.add(new SlowGoblin(spawnTile));
        enemies.add(new RegularGoblin(spawnTile));
        addTimer(new EnemySpawnTimer(2000, enemies));
    }
}
