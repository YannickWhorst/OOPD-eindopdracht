package main.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import main.TowerShower;

public class StartButton extends Button {
    public StartButton(Coordinate2D initialLocation, TowerShower towerShower) {
        super(initialLocation, towerShower, Color.BLUE, "Start", 1);
    }
}
