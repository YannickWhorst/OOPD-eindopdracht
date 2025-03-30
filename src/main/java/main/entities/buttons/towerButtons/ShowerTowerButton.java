package main.entities.buttons.towerButtons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import main.entities.buttons.Button;
import main.entities.map.GameTileMap;

public class ShowerTowerButton extends Button {
    private final GameTileMap gameTileMapInstance = GameTileMap.getInstance();
    public ShowerTowerButton(Coordinate2D initialLocation, Color color, String text) {
        super(initialLocation, color, text);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        gameTileMapInstance.placeTower(9, 4, 10);
        System.out.println("Shower Tower button pressed");
    }
}
