package main.entities.buttons.menuButtons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import main.entities.buttons.Button;

public class HighScoresButton extends Button {
    public HighScoresButton(Coordinate2D initialLocation) {
        super(initialLocation, Color.PURPLE, "High Scores", 2);
    }
}
