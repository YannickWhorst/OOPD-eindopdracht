package main.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import main.TowerShower;

public class HighScoresButton extends Button {
    public HighScoresButton(Coordinate2D initialLocation, TowerShower towerShower) {
        super(initialLocation, towerShower, Color.PURPLE, "High Scores", 2);
    }
}
