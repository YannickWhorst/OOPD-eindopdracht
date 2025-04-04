package main.entities.enemies.slowGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import main.entities.enemies.Hitbox;
import main.entities.text.CurrencyText;
import main.entities.text.HealthText;

public class SlowGoblinHitbox extends Hitbox {
    protected SlowGoblinHitbox
            (Coordinate2D initialLocation, HealthText healthText, CurrencyText currencyText, SlowGoblin slowGoblin, int damage, int health) {
        super(initialLocation, healthText, currencyText, slowGoblin, damage, health);
    }
}
