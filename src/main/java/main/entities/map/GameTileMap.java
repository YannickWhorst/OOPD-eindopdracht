package main.entities.map;

import com.github.hanyaeger.api.scenes.TileMap;
import main.entities.map.tiles.TileType;

public class GameTileMap extends TileMap {
    private static GameTileMap instance;
    private int[][] map;

    private GameTileMap() {
        initializeMap();
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

    private void initializeMap() {
        this.map = new int[][]{
                {2, 1, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2},
                {3, 2, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3},
                {1, 3, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1},
                {2, 1, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 8, 8, 8, 8, 98},
                {3, 2, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 9, 8, 1, 2, 3, 1},
                {1, 3, 2, 3, 1, 8, 8, 8, 8, 8, 1, 2, 3, 1, 2, 8, 3, 1, 2, 3},
                {2, 1, 3, 1, 2, 8, 1, 9, 1, 8, 3, 1, 2, 3, 1, 8, 2, 3, 1, 2},
                {3, 2, 1, 2, 3, 8, 1, 2, 3, 8, 1, 2, 3, 1, 2, 8, 3, 1, 2, 3},
                {1, 3, 2, 3, 1, 8, 1, 2, 3, 8, 9, 1, 2, 3, 9, 8, 1, 2, 3, 1},
                {2, 1, 3, 1, 10, 8, 1, 2, 3, 8, 8, 8, 8, 1, 2, 8, 3, 1, 2, 3},
                {99, 8, 8, 8, 8, 8, 1, 3, 1, 2, 3, 1, 8, 2, 1, 8, 2, 3, 1, 2},
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
    }

    @Override
    public int[][] defineMap() {
        return map;
    }

    public void placeTower(int x, int y, TileType tileType) {
        if (!isValidTile(x, y)) {
            return;
        }

        // TODO: Fix tower placement
        System.out.println("Before: " + map[x][y]);
        map[x][y] = tileType.getId();
        System.out.println("After : " + map[x][y]);
    }

    public boolean isValidTile(int x, int y) {
        return map[x][y] == 9;
    }
}
