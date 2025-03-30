package main.entities.map;

import com.github.hanyaeger.api.scenes.TileMap;

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
        addEntity(1, GrassTile.class, "sprites/tiles/grassTile_variation_1.jpg");
        addEntity(2, GrassTile.class, "sprites/tiles/grassTile_variation_2.jpg");
        addEntity(3, GrassTile.class, "sprites/tiles/flowerTile.jpg");
        addEntity(8, GrassTile.class, "sprites/tiles/pathTile.jpg");
        addEntity(9, TowerTile.class, "sprites/tiles/towerTile.jpg");
    }

    private void initializeMap() {
        this.map = new int[][]{
                {2, 1, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2},
                {3, 2, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3},
                {1, 3, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1},
                {2, 1, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 8, 8, 8, 8, 8},
                {3, 2, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 9, 8, 1, 2, 3, 1},
                {1, 3, 2, 3, 1, 8, 8, 8, 8, 8, 1, 2, 3, 1, 2, 8, 3, 1, 2, 3},
                {2, 1, 3, 1, 2, 8, 1, 9, 1, 8, 3, 1, 2, 3, 1, 8, 2, 3, 1, 2},
                {3, 2, 1, 2, 3, 8, 1, 2, 3, 8, 1, 2, 3, 1, 2, 8, 3, 1, 2, 3},
                {1, 3, 2, 3, 1, 8, 1, 2, 3, 8, 9, 1, 2, 3, 9, 8, 1, 2, 3, 1},
                {2, 1, 3, 1, 9, 8, 1, 2, 3, 8, 8, 8, 8, 1, 2, 8, 3, 1, 2, 3},
                {8, 8, 8, 8, 8, 8, 1, 3, 1, 2, 3, 1, 8, 2, 1, 8, 2, 3, 1, 2},
                {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 8, 2, 3, 8, 2, 1, 2, 3},
                {1, 3, 2, 3, 1, 2, 1, 2, 3, 1, 3, 2, 8, 8, 8, 8, 2, 3, 1, 2},
                {2, 1, 3, 1, 2, 3, 2, 2, 1, 2, 2, 3, 2, 3, 2, 2, 3, 3, 1, 2},
                {3, 2, 1, 2, 3, 1, 2, 3, 1, 2, 1, 2, 1, 2, 1, 2, 3, 3, 1, 2},
                {1, 3, 2, 3, 1, 2, 1, 2, 3, 1, 2, 3, 1, 2, 1, 2, 1, 2, 3, 1},
                {2, 1, 3, 1, 2, 1, 1, 2, 3, 3, 2, 2, 2, 2, 2, 2, 3, 3, 1, 2},
                {3, 2, 1, 2, 3, 1, 3, 1, 2, 2, 2, 1, 1, 2, 3, 3, 3, 3, 3, 1},
                {1, 3, 2, 3, 1, 2, 2, 1, 2, 3, 3, 1, 2, 2, 1, 2, 1, 1, 1, 2},
                {2, 1, 3, 1, 2, 2, 2, 1, 1, 3, 1, 2, 3, 1, 2, 1, 3, 3, 1, 2},
                {3, 2, 1, 2, 3, 1, 2, 2, 2, 2, 2, 1, 1, 2, 1, 2, 1, 1, 1, 2}
        };
    }

    @Override
    public int[][] defineMap() {
        return map;
    }

    public void placeTower(int x, int y, int towerType) {
        if (map[x][y] != 9) {
            return;
        }

        map[x][y] = towerType;
        System.out.println("Tower placed at: " + x + ", " + y);
    }
}
