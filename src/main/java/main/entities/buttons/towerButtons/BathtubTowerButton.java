package main.entities.buttons.towerButtons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import main.TowerShower;
import main.entities.buttons.Button;
import main.entities.map.GameTileMap;
import main.entities.map.tiles.TileType;

public class BathtubTowerButton extends Button {
    private final int tileX, tileY;
    private final GameTileMap gameTileMapInstance = GameTileMap.getInstance();

    public BathtubTowerButton(Coordinate2D initialLocation, Color color, String text, int tileX, int tileY) {
        super(initialLocation, color, text);
        this.tileX = tileX;
        this.tileY = tileY;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        gameTileMapInstance.placeTower(this.tileX, this.tileY, TileType.BATHTUB_TOWER);
        TowerShower.setScene(1);
    }
}
