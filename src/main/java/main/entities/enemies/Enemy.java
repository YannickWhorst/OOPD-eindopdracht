package main.entities.enemies;

import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Enemy extends DynamicSpriteEntity {

    public Enemy(Coordinate2D initialLocation) {
        super("sprites/goblins/regularGoblin.png", initialLocation, new Size(40, 40));
    }

}
