package main.entities.hotbar.towerSelectHotbar;

import com.github.hanyaeger.api.Coordinate2D;
import main.entities.hotbar.HotbarButton;
import main.entities.map.tiles.TileType;

public class PowerwashTowerButton extends HotbarButton {
    public PowerwashTowerButton(Coordinate2D initialLocation, int tileX, int tileY, TowerSelectHotbar towerSelectHotbar) {
        super(initialLocation, tileX, tileY, TileType.POWERWASH_TOWER, "sprites/towers/powerwashTower.png", towerSelectHotbar, 3);
    }
}

