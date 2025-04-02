package main.entities.enemies.regularGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import main.entities.enemies.Enemy;
import main.entities.enemies.Hitbox;
import main.entities.text.HealthText;

public class RegularGoblin extends Enemy {

    public RegularGoblin(Coordinate2D initialLocation, HealthText healthText) {
        super(initialLocation, healthText, 1000);
    }

    @Override
    protected void setupEntities() {
        Hitbox goblinHitbox = new RegularGoblinHitbox
                (new Coordinate2D(-10, -10), healthText, this, 2, 100);
        addEntity(goblinHitbox);
        var goblinSprite = new RegularGoblinSprite(new Coordinate2D(0, 0));
        addEntity(goblinSprite);
    }
}
