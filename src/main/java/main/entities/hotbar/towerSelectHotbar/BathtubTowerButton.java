package main.entities.hotbar.towerSelectHotbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import main.entities.map.GameTileMap;
import main.entities.map.tiles.TileType;

public class BathtubTowerButton extends SpriteEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final int tileX, tileY;
    private final TowerSelectHotbar towerSelectHotbar;

    public BathtubTowerButton(Coordinate2D initialLocation, int tileX, int tileY, TowerSelectHotbar towerSelectHotbar) {
        super("sprites/towers/bathtubTower.png", initialLocation, new Size(50));
        this.tileX = tileX;
        this.tileY = tileY;
        this.towerSelectHotbar = towerSelectHotbar;
    }

    public void onMouseEntered() {
        setCursor(Cursor.HAND);
    }

    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        GameTileMap.getInstance().placeTower(this.tileX, this.tileY, TileType.BATHTUB_TOWER);
        towerSelectHotbar.remove();
    }
}
