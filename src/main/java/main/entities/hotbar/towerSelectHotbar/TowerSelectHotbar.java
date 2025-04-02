package main.entities.hotbar.towerSelectHotbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import main.scene.GameScene;

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
        addEntity(new HotbarBackground(new Coordinate2D(150, 25), new Size(400, 70)));
        addEntity(new ShowerTowerButton(new Coordinate2D(0, 0), tileX, tileY, this));
    }
}
