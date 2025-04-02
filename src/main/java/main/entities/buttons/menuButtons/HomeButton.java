package main.entities.buttons.menuButtons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import main.entities.buttons.Button;

public class HomeButton extends Button {
    public HomeButton(Coordinate2D initialLocation) {
        super(initialLocation, Color.BLUE, "Terug naar Home", 0);
    }
}
