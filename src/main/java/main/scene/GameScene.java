package main.scene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import main.entities.hotbar.towerSelectHotbar.TowerSelectHotbar;
import main.entities.map.GameTileMap;
import main.entities.text.HealthText;

public class GameScene extends DynamicScene implements TileMapContainer {
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
}
