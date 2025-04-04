package main.scene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import main.TowerShower;
import main.entities.enemies.Enemy;
import main.entities.enemies.fastGoblin.FastGoblin;
import main.entities.enemies.regularGoblin.RegularGoblin;
import main.entities.enemies.slowGoblin.SlowGoblin;
import main.entities.map.GameTileMap;
import main.entities.text.CurrencyText;
import main.entities.text.HealthText;
import main.timers.EnemySpawnTimer;

import java.util.ArrayList;

public class GameScene extends DynamicScene implements TileMapContainer, TimerContainer {
    private int health = 10;
    private int currency = 200;
    private final GameTileMap tileMap;
    public HealthText healthText = new HealthText(new Coordinate2D(0, 0));
    public CurrencyText currencyText = new CurrencyText(new Coordinate2D(0, healthText.getHeight() + 40));
    private static GameScene instance;

    private GameScene() {
        tileMap = GameTileMap.getInstance();
    }

    // TODO: getInstance() weg halen zodat we geen static variablen meer hebben,
    // tenzij het niet anders kan
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
        healthText.setHealthText(10);
        addEntity(healthText);

        currencyText.setCurrencyText(200);
        addEntity(currencyText);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(tileMap);
    }

    private Coordinate2D findSpawnTile() {
        int[][] map = tileMap.defineMap();

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == 99) {
                    return new Coordinate2D(x * 40, y * 40);
                }
            }
        }

        return null;
    }

    public void addNewEntity(YaegerEntity yaegerEntity) {
        addEntity(yaegerEntity);
    }

    @Override
    public void setupTimers() {
        Coordinate2D spawnTile = findSpawnTile();
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new FastGoblin(spawnTile, healthText, currencyText));
        enemies.add(new FastGoblin(spawnTile, healthText, currencyText));
        enemies.add(new RegularGoblin(spawnTile, healthText, currencyText));
        enemies.add(new RegularGoblin(spawnTile, healthText, currencyText));
        enemies.add(new SlowGoblin(spawnTile, healthText, currencyText));
        enemies.add(new RegularGoblin(spawnTile, healthText, currencyText));
        addTimer(new EnemySpawnTimer(2000, enemies));
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            TowerShower.setScene(3);
        }

        this.health = health;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

}
