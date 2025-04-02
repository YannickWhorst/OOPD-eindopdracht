package main.entities.enemies.slowGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class SlowGoblinSprite extends DynamicSpriteEntity {

    public SlowGoblinSprite(final Coordinate2D initialLocation) {
        super("sprites/goblins/slowGoblin.png", initialLocation, new Size(40, 40));
    }
}