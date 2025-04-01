package main.scene;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.Coordinate2D;
import main.entities.enemies.GoblinSpawner;
import main.entities.enemies.regularGoblin.RegularGoblin;
import main.entities.hotbar.towerSelectHotbar.TowerSelectHotbar;
import main.entities.enemies.slowGoblin.SlowGoblin;
import main.entities.map.GameTileMap;
import main.entities.text.HealthText;

public class GameScene extends DynamicScene implements TileMapContainer, EntitySpawnerContainer {
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
        spawnEnemy();

        addEntity(new TowerSelectHotbar(new Coordinate2D(getWidth() / 2, getHeight() - 50)));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(GameTileMap.getInstance());
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


    @Override
    public void setupEntitySpawners() {
        int[] enemies = {1, 2, 2, 2, 1}; // Array of goblin IDs (RegularGoblin and SlowGoblin)
        addEntitySpawner(new GoblinSpawner(5000, enemies)); // Start spawning enemies with a 5-second interval
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
