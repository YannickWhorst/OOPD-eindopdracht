package main.entities.hotbar.towerSelectHotbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;

public class TowerSelectHotbar extends CompositeEntity {
    private final int tileX;
    private final int tileY;

    public TowerSelectHotbar(Coordinate2D initialLocation, int tileX, int tileY) {
        super(initialLocation);
        this.tileX = tileX;
        this.tileY = tileY;
    }

    protected void setupEntities() {
        HotbarBackground hotbarBackground =
                new HotbarBackground(new Coordinate2D(150, 25), new Size(400, 70));
        ShowerTowerButton showerTowerButton =
                new ShowerTowerButton(new Coordinate2D(0, 0), tileX, tileY, this);
        BathtubTowerButton bathtubTowerButton =
                new BathtubTowerButton(new Coordinate2D(60, 0), tileX, tileY, this);

        addEntity(hotbarBackground);
        addEntity(showerTowerButton);
        addEntity(bathtubTowerButton);
    }
}
