package main.entities.hotbar.towerSelectHotbar;

import com.github.hanyaeger.api.Coordinate2D;
import main.entities.hotbar.HotbarButton;
import main.entities.map.tiles.TileType;

public class ShowerTowerButton extends HotbarButton {
    public ShowerTowerButton(Coordinate2D initialLocation, int tileX, int tileY, TowerSelectHotbar towerSelectHotbar) {
        super(initialLocation, tileX, tileY, TileType.SHOWER_TOWER, "sprites/towers/showerTower.png", towerSelectHotbar, 1);
    }
}
