package main.entities.map.tiles;

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
import main.scene.GameScene;

public class TowerTile extends SpriteEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private static int tileX, tileY;
    private final GameTileMap gameTileMap = GameTileMap.getInstance();

    public TowerTile(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        getLatestTileLocation(coordinate2D);

        TowerSelectHotbar hotbar = new TowerSelectHotbar(new Coordinate2D(250, 700), tileX, tileY);

        GameScene.getInstance().addNewEntity(hotbar);
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
    }

    private void getLatestTileLocation(Coordinate2D coordinate2D) {
        int TILE_WIDTH = 40;
        int tileX = (int) (coordinate2D.getY() / TILE_WIDTH);
        int TILE_HEIGHT = 40;
        int tileY = (int) (coordinate2D.getX() / TILE_HEIGHT);

        if (gameTileMap.isValidTile(tileX, tileY)) {
            setTileX(tileX);
            setTileY(tileY);
        }
    }

    public static void setTileX(int tileX) {
        TowerTile.tileX = tileX;
    }

    public static void setTileY(int tileY) {
        TowerTile.tileY = tileY;
    }
}