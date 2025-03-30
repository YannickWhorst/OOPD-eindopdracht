package main.scene;

import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.Coordinate2D;
import main.entities.enemies.Enemy;
import main.entities.map.GameTileMap;

public class GameScene extends DynamicScene implements TileMapContainer {

    @Override
    public void setupScene() {
        // Configuraties voor de scene (bijv. achtergrondmuziek, etc.)
    }

    @Override
    public void setupEntities() {
        spawnEnemy();
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
                    System.out.println("SpawnTile gevonden op: (" + x + ", " + y + ")");
                    return new Coordinate2D(x * 40, y * 40); // Return de spawnlocatie als Coordinate2D
                }
            }
        }
        return null; // Geen spawnTile gevonden
    }

    private void spawnEnemy() {
        Coordinate2D spawnLocation = findSpawnTile();
        if (spawnLocation != null) {
            Enemy enemy = new Enemy(spawnLocation);
            addEntity(enemy);
        } else {
            System.out.println("Geen spawnTile gevonden!");
        }
    }
}
