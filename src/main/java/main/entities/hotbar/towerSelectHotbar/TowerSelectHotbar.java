package main.entities.hotbar.towerSelectHotbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import main.entities.hotbar.HotbarButton;

public class TowerSelectHotbar extends CompositeEntity {
    private final int tileX;
    private final int tileY;

    // TODO: Keep track of the opened hotbar and not open it when its already opened
    public TowerSelectHotbar(Coordinate2D initialLocation, int tileX, int tileY) {
        super(initialLocation);
        this.tileX = tileX;
        this.tileY = tileY;
    }

    protected void setupEntities() {
        HotbarBackground hotbarBackground =
                new HotbarBackground(new Coordinate2D(150, 25), new Size(400, 70));

        HotbarButton showerTowerButton =
                new ShowerTowerButton(new Coordinate2D(0, 0), tileX, tileY, this);

        HotbarButton bathtubTowerButton =
                new BathtubTowerButton(new Coordinate2D(60, 0), tileX, tileY, this);

        HotbarButton PowerwashTowerButton =
                new PowerwashTowerButton(new Coordinate2D(120, 0), tileX, tileY, this);

        HotbarButton SoapTowerButton =
                new SoapTowerButton(new Coordinate2D(180, 0), tileX, tileY, this);

        addEntity(hotbarBackground);
        addEntity(showerTowerButton);
        addEntity(bathtubTowerButton);
        addEntity(PowerwashTowerButton);
        addEntity(SoapTowerButton);
    }
}
