package main.entities.hotbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import main.entities.hotbar.towerSelectHotbar.TowerSelectHotbar;
import main.entities.map.GameTileMap;
import main.entities.map.tiles.TileType;
import java.util.Set;

public class HotbarButton extends SpriteEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener, KeyListener {
    private final int tileX, tileY;
    private final GameTileMap gameTileMapInstance = GameTileMap.getInstance();
    private final TileType tileType;
    private final TowerSelectHotbar towerSelectHotbar;
    private final int hotbarIndex;

    public HotbarButton(Coordinate2D initialLocation, int tileX, int tileY, TileType tileType, String resource, TowerSelectHotbar towerSelectHotbar, int hotbarIndex) {
        super(resource, initialLocation, new Size(50));
        this.tileX = tileX;
        this.tileY = tileY;
        this.tileType = tileType;
        this.towerSelectHotbar = towerSelectHotbar;
        this.hotbarIndex = hotbarIndex; // Nummer in de hotbar (1, 2, 3, ...)
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        placeTower();
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        // Check of het nummer overeenkomt met de hotbar index (1 = DIGIT1, 2 = DIGIT2, etc.)
        if (pressedKeys.contains(KeyCode.getKeyCode(Integer.toString(hotbarIndex)))) {
            placeTower();
        }
    }

    private void placeTower() {
        gameTileMapInstance.placeTower(this.tileX, this.tileY, tileType);
        towerSelectHotbar.remove();
        System.out.println("placed: " + tileType);
    }
}
