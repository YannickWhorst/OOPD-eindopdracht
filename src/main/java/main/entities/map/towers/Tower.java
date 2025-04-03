package main.entities.map.towers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Tower extends DynamicSpriteEntity implements Collider {
    private final int damage;

    public Tower(Coordinate2D initialLocation, Size size, String resource/*, int damage*/) {
        super(resource, initialLocation, size);
        this.damage = 15;
    }

    public int getDamage() {
        return damage;
    }
}
