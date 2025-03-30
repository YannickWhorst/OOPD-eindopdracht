package main.entities.buttons.menuButtons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import main.entities.buttons.Button;

public class StartButton extends Button {
    public StartButton(Coordinate2D initialLocation) {
        super(initialLocation, Color.BLUE, "Start", 1);
    }
}
