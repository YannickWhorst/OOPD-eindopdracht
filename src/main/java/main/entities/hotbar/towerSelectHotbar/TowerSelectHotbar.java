package main.entities.hotbar.towerSelectHotbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import javafx.scene.paint.Color;
import main.entities.map.tiles.TowerTile;

public class TowerSelectHotbar extends CompositeEntity {
    public TowerSelectHotbar(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        addEntity(new ShowerTowerButton(new Coordinate2D(0 ,0), Color.BLUE, "Shower Tower", TowerTile.getTileX(), TowerTile.getTileY()));
    }
}