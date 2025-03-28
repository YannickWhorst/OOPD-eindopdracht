package main.entities.map;

import com.github.hanyaeger.api.scenes.TileMap;

public class GameTileMap extends TileMap {
    @Override
    public void setupEntities() {
        addEntity(1, GrassTile.class, "sprites/tiles/grassTile_variation_1.jpg");
        addEntity(2, GrassTile.class, "sprites/tiles/grassTile_variation_2.jpg");
        addEntity(3, GrassTile.class, "sprites/tiles/flowerTile.jpg");
        addEntity(8, GrassTile.class, "sprites/tiles/pathTile.jpg");
        addEntity(9, TowerTile.class, "sprites/tiles/towerTile.jpg");
    }

    @Override
    public int[][] defineMap() {
        return new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 2, 2, 3, 3, 2, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 3, 1, 1, 8, 8, 8, 8},
                {1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 8, 1, 1, 1},
                {1, 3, 3, 2, 2, 8, 8, 8, 8, 8, 1, 1, 1, 1, 3, 8, 1, 1, 1},
                {1, 3, 3, 1, 1, 8, 1, 9, 1, 8, 1, 1, 3, 1, 1, 8, 1, 1, 1},
                {1, 1, 1, 1, 1, 8, 1, 1, 1, 8, 1, 1, 3, 1, 1, 8, 1, 1, 1},
                {1, 1, 1, 1, 1, 8, 1, 1, 1, 8, 9, 1, 1, 1, 9, 8, 1, 1, 1},
                {1, 1, 1, 1, 9, 8, 1, 1, 1, 8, 8, 8, 8, 8, 8, 8, 1, 1, 1},
                {8, 8, 8, 8, 8, 8, 1, 3, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1},
                {1, 1, 3, 2, 2, 2, 1, 1, 1, 1, 3, 3, 2, 2, 2, 2, 2, 3, 1},
                {1, 1, 2, 2, 2, 3, 2, 2, 1, 1, 2, 3, 2, 3, 2, 2, 3, 3, 1},
                {1, 1, 2, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1},
                {1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
    }

}
