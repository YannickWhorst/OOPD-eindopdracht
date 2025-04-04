package main.entities.map.towers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;

public abstract class Tower extends DynamicSpriteEntity implements Collider, MouseEnterListener, MouseExitListener {
    private final int damage;

    public Tower(Coordinate2D initialLocation, Size size, String resource, int damage) {
        super(resource, initialLocation, size);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
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
