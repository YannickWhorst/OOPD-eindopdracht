package main.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class StartButton extends Button {
    public StartButton(Coordinate2D initialLocation) {
        super(initialLocation, Color.BLUE, "Start", 1);
    }
}
