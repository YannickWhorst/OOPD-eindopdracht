package main.scene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.application.Platform;
import main.entities.enemies.Enemy;
import main.entities.enemies.fastGoblin.FastGoblin;
import main.entities.enemies.regularGoblin.RegularGoblin;
import main.entities.enemies.slowGoblin.SlowGoblin;
import main.entities.map.GameTileMap;
import main.entities.text.CurrencyText;
import main.entities.text.HealthText;
import main.logic.ScoreManager;
import main.timers.EnemySpawnTimer;

import java.util.ArrayList;

import static main.TowerShower.setScene;

public class GameScene extends DynamicScene implements TileMapContainer, TimerContainer {
    private int health = 10;
    private int currency = 200;
    private final GameTileMap tileMap;
    public HealthText healthText = new HealthText(new Coordinate2D(0, 0));
    public CurrencyText currencyText = new CurrencyText(new Coordinate2D(0, healthText.getHeight() + 40));
    private final ScoreManager scoreManager = new ScoreManager();
    private int enemyCount = 0;

    private static GameScene instance;

    private GameScene() {
        tileMap = GameTileMap.getInstance();
    }

    public static GameScene getInstance() {
        if (instance == null) {
            instance = new GameScene();
        }
        return instance;
    }

    @Override
    public void setupScene() {
        scoreManager.resetScore();
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

    public void enemySpawned() {
        enemyCount++;
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
            setScene(3);
        }

        enemyAttack();

        this.health = health;
    }

    public void enemyKilled() {
        enemyCount--;
        scoreManager.addScore(100);
    }

    public void enemyAttack() {
        enemyCount--;
        scoreManager.addScore(-50);

        if (getEnemyCount() == 0) {
            Platform.runLater(this::goToWinScene);
        }
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public ScoreManager getScoreManager() {
        return scoreManager;
    }

    public int getCurrency() {
        return currency;
    }

    public void goToWinScene() {
        scoreManager.saveScore("speler");

        setScene(4); // WinScene
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

}
