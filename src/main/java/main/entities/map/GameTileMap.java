package main.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.TileMap;
import main.entities.map.tiles.TileType;
import main.entities.map.tiles.TowerTile;
import main.entities.map.towers.BadkuipTower;
import main.entities.map.towers.DouchekopTower;
import main.entities.map.towers.PowerwashTower;
import main.entities.map.towers.SoapTower;
import main.scene.GameScene;

public class GameTileMap extends TileMap {
    private static GameTileMap instance;
    private int[][] map;

    private GameTileMap() {
    }

    public static GameTileMap getInstance() {
        if (instance == null) {
            instance = new GameTileMap();
        }

        return instance;
    }

    @Override
    public void setupEntities() {
        for (TileType tileType : TileType.values()) {
            addEntity(tileType.getId(), tileType.getEntityClass(), tileType.getSpritePath());
        }
    }

    @Override
    public int[][] defineMap() {
        if (this.map != null) {
            return this.map;
        }

        this.map = new int[][]{
                {2, 1, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2},
                {3, 2, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3},
                {1, 3, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1},
                {2, 1, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 8, 8, 97, 8, 98},
                {3, 2, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 9, 8, 1, 2, 3, 1},
                {1, 3, 2, 3, 1, 8, 8, 8, 8, 97, 1, 2, 3, 1, 2, 8, 3, 1, 2, 3},
                {2, 1, 3, 1, 2, 8, 1, 9, 1, 8, 3, 1, 2, 3, 1, 97, 2, 3, 1, 2},
                {3, 2, 1, 2, 1, 97, 1, 2, 2, 8, 1, 2, 3, 1, 2, 8, 3, 1, 2, 3},
                {1, 3, 2, 3, 1, 8, 1, 2, 2, 8, 9, 1, 2, 3, 9, 8, 1, 2, 3, 1},
                {2, 1, 3, 1, 9, 8, 1, 2, 3, 8, 8, 8, 97, 1, 2, 8, 3, 1, 2, 3},
                {99, 8, 8, 8, 8, 8, 1, 3, 1, 2, 3, 3, 8, 2, 1, 8, 2, 3, 1, 2},
                {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 8, 2, 3, 8, 2, 1, 2, 3},
                {1, 3, 2, 3, 1, 2, 1, 2, 3, 1, 3, 2, 8, 8, 8, 8, 2, 3, 1, 2},
                {2, 1, 3, 1, 2, 3, 2, 2, 1, 2, 2, 3, 2, 3, 2, 2, 3, 3, 1, 2},
                {3, 2, 1, 2, 3, 1, 2, 3, 1, 2, 1, 2, 1, 2, 1, 2, 3, 3, 1, 2},
                {1, 3, 2, 3, 1, 2, 1, 2, 3, 1, 2, 3, 1, 2, 1, 2, 1, 2, 3, 1},
                {2, 1, 3, 1, 2, 1, 1, 2, 3, 3, 2, 2, 2, 2, 2, 2, 3, 3, 1, 2},
                {3, 2, 1, 2, 3, 1, 3, 1, 2, 2, 2, 1, 1, 2, 3, 3, 3, 3, 3, 1},
                {1, 3, 2, 3, 1, 2, 2, 1, 2, 3, 3, 1, 2, 2, 1, 2, 1, 1, 1, 2},
                {2, 1, 3, 1, 2, 2, 2, 1, 1, 3, 1, 2, 3, 1, 2, 1, 3, 3, 1, 2}
        };

        return this.map;
    }

    public void placeTower(int x, int y, TileType tileType) {
        if (!isValidTile(x, y)) {
            return;
        }

        map[x][y] = tileType.getId();
        YaegerEntity tower = createTower(tileType, x, y);

        GameScene.getInstance().addNewEntity(tower);
    }

    private YaegerEntity createTower(TileType tileType, int x, int y) {
        int TILE_SIZE = 40;
        Coordinate2D position = new Coordinate2D(y * TILE_SIZE, x * TILE_SIZE);
        Size size = new Size(TILE_SIZE);
        String spritePath = tileType.getSpritePath();

        return switch (tileType) {
            case SHOWER_TOWER -> new DouchekopTower(position, size, spritePath);
            case BATHTUB_TOWER -> new BadkuipTower(position, size, spritePath);
            case POWERWASH_TOWER -> new PowerwashTower(position, size, spritePath);
            case SOAP_TOWER -> new SoapTower(position, size, spritePath);
            default -> new TowerTile(position, size, spritePath);
        };
    }

    public boolean isValidTile(int x, int y) {
        return map[x][y] == TileType.TOWER_TILE.getId();
    }
}
