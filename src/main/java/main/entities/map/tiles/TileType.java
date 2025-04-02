package main.entities.map.tiles;

import com.github.hanyaeger.api.entities.YaegerEntity;
import main.entities.towers.BadkuipTower;
import main.entities.towers.DouchekopTower;

public enum TileType {
    GRASS_VARIATION_1(1, GrassTile.class, "sprites/tiles/grassTile_variation_1.jpg"),
    GRASS_VARIATION_2(2, GrassTile.class, "sprites/tiles/grassTile_variation_2.jpg"),
    FLOWER(3, GrassTile.class, "sprites/tiles/flowerTile.jpg"),
    PATH(8, GrassTile.class, "sprites/tiles/pathTile.jpg"),
    END(98, EndTile.class, "sprites/tiles/endTile.jpg"),
    SPAWN(99, GrassTile.class, "sprites/tiles/spawnTile.jpg"),
    TOWER_TILE(9, TowerTile.class, "sprites/tiles/towerTile.jpg"),
    SHOWER_TOWER(10, DouchekopTower.class, "sprites/towers/showerTower.png"),
    BATHTUB_TOWER(11, BadkuipTower.class, "sprites/towers/bathtubTower.png");

    private final int id;
    private final Class<? extends YaegerEntity> entityClass;
    private final String spritePath;

    TileType(int id, Class<? extends YaegerEntity> entityClass, String spritePath) {
        this.id = id;
        this.entityClass = entityClass;
        this.spritePath = spritePath;
    }

    public int getId() {
        return id;
    }

    public String getSpritePath() {
        return spritePath;
    }

    public Class<? extends YaegerEntity> getEntityClass() {
        return entityClass;
    }
}