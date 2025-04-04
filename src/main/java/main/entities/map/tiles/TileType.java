package main.entities.map.tiles;

import com.github.hanyaeger.api.entities.YaegerEntity;
import main.entities.map.towers.BadkuipTower;
import main.entities.map.towers.DouchekopTower;
import main.entities.map.towers.PowerwashTower;
import main.entities.map.towers.SoapTower;

public enum TileType {
    GRASS_VARIATION_1(1, GrassTile.class, "sprites/tiles/grassTile_variation_1.jpg", 0),
    GRASS_VARIATION_2(2, GrassTile.class, "sprites/tiles/grassTile_variation_2.jpg",0 ),
    FLOWER(3, GrassTile.class, "sprites/tiles/flowerTile.jpg", 0),
    PATH(8, GrassTile.class, "sprites/tiles/pathTile.jpg", 0),
    PASSED_TOWER(97, PassedTowerTile.class, "sprites/tiles/pathTile.jpg", 0),
    END(98, EndTile.class, "sprites/tiles/endTile.jpg", 0),
    SPAWN(99, GrassTile.class, "sprites/tiles/spawnTile.jpg", 0),
    TOWER_TILE(9, TowerTile.class, "sprites/tiles/towerTile.jpg", 0),
    SHOWER_TOWER(10, DouchekopTower.class, "sprites/towers/showerTower.png", 50),
    BATHTUB_TOWER(11, BadkuipTower.class, "sprites/towers/bathtubTower.png", 75),
    POWERWASH_TOWER(11, PowerwashTower.class, "sprites/towers/powerwashTower.png", 100),
    SOAP_TOWER(11, SoapTower.class, "sprites/towers/soapTower.png", 125);

    private final int id;
    private final Class<? extends YaegerEntity> entityClass;
    private final String spritePath;
    private final int towerCost;

    TileType(int id, Class<? extends YaegerEntity> entityClass, String spritePath, int towerCost) {
        this.id = id;
        this.entityClass = entityClass;
        this.spritePath = spritePath;
        this.towerCost = towerCost;
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

    public int getTowerCost() {
        return towerCost;
    }
}