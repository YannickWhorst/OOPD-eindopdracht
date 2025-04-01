package main.entities.hotbar.towerSelectHotbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;

public class TowerSelectHotbar extends CompositeEntity {
    private final int tileX;
    private final int tileY;

    public TowerSelectHotbar(Coordinate2D initialLocation, int tileX, int tileY) {
        super(initialLocation);
        this.tileX = tileX;
        this.tileY = tileY;
    }

    @Override
    protected void setupEntities() {
        // Gebruik de correcte tegelcoördinaten
        addEntity(new ShowerTowerButton(new Coordinate2D(0, 0), tileX, tileY));
    }
}
