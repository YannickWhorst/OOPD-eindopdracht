package main.entities.enemies.regularGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;

public class RegularGoblinSprite extends DynamicSpriteEntity implements MouseEnterListener, MouseExitListener {

    public RegularGoblinSprite(final Coordinate2D initialLocation) {
        super("sprites/goblins/regularGoblin.png", initialLocation, new Size(40, 40));
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