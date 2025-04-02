package main.entities.enemies.regularGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class RegularGoblinSprite extends DynamicSpriteEntity {

    public RegularGoblinSprite(final Coordinate2D initialLocation) {
        super("sprites/goblins/regularGoblin.png", initialLocation, new Size(40, 40));
    }
}