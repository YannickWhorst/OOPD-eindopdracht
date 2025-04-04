package main.entities.enemies.slowGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import main.entities.enemies.Enemy;
import main.entities.enemies.Hitbox;
import main.entities.text.CurrencyText;
import main.entities.text.HealthText;

public class SlowGoblin extends Enemy {

    public SlowGoblin(Coordinate2D initialLocation, HealthText healthText, CurrencyText currencyText) {
        super(initialLocation, healthText, currencyText, 1500);
    }

    @Override
    protected void setupEntities() {
        Hitbox hitbox = new SlowGoblinHitbox
                (new Coordinate2D(-10, -10), healthText, currencyText, this, 3, 150);
        addEntity(hitbox);

        var goblinSprite = new SlowGoblinSprite(new Coordinate2D(0, 0));
        addEntity(goblinSprite);
    }
}
