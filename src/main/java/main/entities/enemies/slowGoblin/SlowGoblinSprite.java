package main.entities.enemies.slowGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;

public class SlowGoblinSprite extends DynamicSpriteEntity implements MouseEnterListener, MouseExitListener {

    public SlowGoblinSprite(final Coordinate2D initialLocation) {
        super("sprites/goblins/slowGoblin.png", initialLocation, new Size(40, 40));
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