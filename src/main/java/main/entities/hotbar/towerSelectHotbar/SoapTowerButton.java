package main.entities.hotbar.towerSelectHotbar;

import com.github.hanyaeger.api.Coordinate2D;
import main.entities.hotbar.HotbarButton;
import main.entities.map.tiles.TileType;

public class SoapTowerButton extends HotbarButton {

    public SoapTowerButton(Coordinate2D initialLocation, int tileX, int tileY, TowerSelectHotbar towerSelectHotbar) {
        super(initialLocation, tileX, tileY, TileType.SOAP_TOWER, "sprites/towers/soapTower.png", towerSelectHotbar, 4);
    }
}

