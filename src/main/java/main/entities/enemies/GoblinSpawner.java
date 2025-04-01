package main.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import main.entities.enemies.regularGoblin.RegularGoblin;
import main.entities.enemies.slowGoblin.SlowGoblin;
import main.entities.map.GameTileMap;
import com.github.hanyaeger.api.Timer;

public class GoblinSpawner extends EntitySpawner {

    private int[] goblinIds; // Array van goblin IDs
    private int currentIndex = 0; // Houdt bij welke goblin we moeten spawnen
    private Timer spawnTimer;

    // Constructor waarbij het interval en de array van IDs meegegeven worden
    public GoblinSpawner(long intervalInMs, int[] goblinIds) {
        super(intervalInMs);
        this.goblinIds = goblinIds;

        // Timer om vijanden één voor één te spawnen
        spawnTimer = new Timer(intervalInMs) {
            @Override
            public void onAnimationUpdate(long now) {
                spawnNextEnemy();
            }
        };
        spawnTimer.reset();  // Zorg ervoor dat de timer correct wordt ingesteld
        spawnTimer.resume(); // Timer starten
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

    // Functie die wordt aangeroepen door de timer om de volgende vijand te spawnen
    private void spawnNextEnemy() {
        if (currentIndex < goblinIds.length) {
            int id = goblinIds[currentIndex];
            Coordinate2D spawnLocation = findSpawnTile();

            // Spawn de juiste goblin op basis van de ID
            if (id == 1) {
                RegularGoblin goblin = new RegularGoblin(spawnLocation);
                spawn(goblin);
            } else if (id == 2) {
                SlowGoblin goblin = new SlowGoblin(spawnLocation);
                spawn(goblin);
            }

            currentIndex++; // Verhoog de index voor de volgende vijand
        } else {
            spawnTimer.remove(); // Stop de timer als alle vijanden zijn gespawnd
        }
    }

    @Override
    protected void spawnEntities() {
        // De timer zorgt ervoor dat de vijanden één voor één worden gespawnd
    }
}
