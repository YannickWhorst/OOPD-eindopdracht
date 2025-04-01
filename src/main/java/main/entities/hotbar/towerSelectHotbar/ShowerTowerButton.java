package main.entities.hotbar.towerSelectHotbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import main.TowerShower;
import main.entities.buttons.Button;
import main.entities.map.GameTileMap;
import main.entities.map.tiles.TileType;
import main.scene.GameScene;

public class ShowerTowerButton extends SpriteEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final int tileX, tileY;
    private final GameTileMap gameTileMapInstance = GameTileMap.getInstance();

    public ShowerTowerButton(Coordinate2D initialLocation, int tileX, int tileY) {
        super("sprites/towers/showerTower.png", initialLocation, new Size(50));
        this.tileX = tileX;
        this.tileY = tileY;
    }

    public void onMouseEntered() {
        setCursor(Cursor.HAND);
    }

    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        gameTileMapInstance.placeTower(this.tileX, this.tileY, TileType.SHOWER_TOWER);
        TowerShower.setScene(1);
    }
}
