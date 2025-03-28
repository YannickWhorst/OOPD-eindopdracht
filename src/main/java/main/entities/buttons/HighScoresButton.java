package main.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class HighScoresButton extends Button {
    public HighScoresButton(Coordinate2D initialLocation) {
        super(initialLocation, Color.PURPLE, "High Scores", 2);
    }
}
