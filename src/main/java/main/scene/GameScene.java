package main.scene;

import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import main.entities.map.GameTileMap;

public class GameScene extends DynamicScene implements TileMapContainer {
    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {

    }

    @Override
    public void setupTileMaps() {
        addTileMap(new GameTileMap());
    }
}
