package main.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import main.TowerShower;

public class QuitButton extends Button {

    public QuitButton(Coordinate2D initialLocation, Color color, String text) {
        super(initialLocation, color, text);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        TowerShower.quitGame();
    }
}
