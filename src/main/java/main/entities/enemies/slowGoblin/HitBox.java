package main.entities.enemies.slowGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class HitBox extends RectangleEntity implements Collided {
    protected HitBox(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(60);
        setHeight(60);
        setFill(Color.RED);
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        System.out.println("HitBox collided with: " + collidingObjects);
    }

}
