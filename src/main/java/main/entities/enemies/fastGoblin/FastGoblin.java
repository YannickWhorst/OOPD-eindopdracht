package main.entities.enemies.fastGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import main.entities.enemies.Enemy;
import main.entities.enemies.Hitbox;
import main.entities.text.CurrencyText;
import main.entities.text.HealthText;

public class FastGoblin extends Enemy {

    public FastGoblin(Coordinate2D initialLocation, HealthText healthText, CurrencyText currencyText) {
        super(initialLocation, healthText, currencyText, 500);
    }

    @Override
    protected void setupEntities() {
        Hitbox goblinHitbox = new FastGoblinHitbox
                (new Coordinate2D(-10, -10), healthText, currencyText, this, 1, 75);
        addEntity(goblinHitbox);

        var goblinSprite = new FastGoblinSprite(new Coordinate2D(0, 0));
        addEntity(goblinSprite);
    }
}