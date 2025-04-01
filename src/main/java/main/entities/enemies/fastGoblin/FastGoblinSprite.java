package main.entities.enemies.fastGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;

public class FastGoblinSprite extends DynamicSpriteEntity implements MouseEnterListener, MouseExitListener {

    public FastGoblinSprite(final Coordinate2D initialLocation) {
        super("sprites/goblins/fastGoblin.png", initialLocation, new Size(40, 40));
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
    }
}