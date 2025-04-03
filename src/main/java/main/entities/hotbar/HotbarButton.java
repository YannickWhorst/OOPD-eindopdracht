package main.entities.hotbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import main.entities.hotbar.towerSelectHotbar.TowerSelectHotbar;
import main.entities.map.GameTileMap;
import main.entities.map.tiles.TileType;

public class HotbarButton extends SpriteEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final int tileX, tileY;
    private final GameTileMap gameTileMapInstance = GameTileMap.getInstance();
    private final TileType tileType;
    private final TowerSelectHotbar towerSelectHotbar;

    public HotbarButton(Coordinate2D initialLocation, int tileX, int tileY, TileType tileType, String resource, TowerSelectHotbar towerSelectHotbar) {
        super(resource, initialLocation, new Size(50));
        this.tileX = tileX;
        this.tileY = tileY;
        this.tileType = tileType;
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
        gameTileMapInstance.placeTower(this.tileX, this.tileY, tileType);
        towerSelectHotbar.remove();
    }
}
