package main.entities.enemies.fastGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class FastGoblinSprite extends DynamicSpriteEntity {

    public FastGoblinSprite(final Coordinate2D initialLocation) {
        super("sprites/goblins/fastGoblin.png", initialLocation, new Size(40, 40));
    }
}