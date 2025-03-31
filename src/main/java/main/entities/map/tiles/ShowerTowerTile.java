package main.entities.map.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;

public class ShowerTowerTile extends DynamicSpriteEntity implements MouseEnterListener, MouseExitListener, Collider {
    private int damamage = 10;

    public ShowerTowerTile(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
    }

}