package main.entities.hotbar.towerSelectHotbar;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class HotbarBackground extends RectangleEntity {
    protected HotbarBackground(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.LIGHTGRAY);
    }
}
