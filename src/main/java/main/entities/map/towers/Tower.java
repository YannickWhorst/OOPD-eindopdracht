package main.entities.map.towers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.Cursor;
import javafx.scene.input.KeyCode;

public abstract class Tower extends DynamicSpriteEntity implements Collider, MouseEnterListener, MouseExitListener {
    private final int damage;
    private boolean isHovered = false;

    public Tower(Coordinate2D initialLocation, Size size, String resource, int damage) {
        super(resource, initialLocation, size);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isHovered() {
        return isHovered;
    }

    @Override
    public void onMouseEntered() {
        isHovered = true;
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        isHovered = false;
        setCursor(Cursor.DEFAULT);
    }

}
