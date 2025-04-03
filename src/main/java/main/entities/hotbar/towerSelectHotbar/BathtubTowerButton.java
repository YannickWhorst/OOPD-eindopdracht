package main.entities.hotbar.towerSelectHotbar;

import com.github.hanyaeger.api.Coordinate2D;
import main.entities.hotbar.HotbarButton;
import main.entities.map.tiles.TileType;

public class BathtubTowerButton extends HotbarButton {

    public BathtubTowerButton(Coordinate2D initialLocation, int tileX, int tileY, TowerSelectHotbar towerSelectHotbar) {
        super(initialLocation, tileX, tileY, TileType.BATHTUB_TOWER, "sprites/towers/bathtubTower.png", towerSelectHotbar, 2);
    }
}

