package main.entities.enemies.regularGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import main.entities.enemies.Hitbox;
import main.entities.text.CurrencyText;
import main.entities.text.HealthText;

public class RegularGoblinHitbox extends Hitbox {
    protected RegularGoblinHitbox
            (Coordinate2D initialLocation, HealthText healthText, CurrencyText currencyText, RegularGoblin regularGoblin, int damage, int health) {
        super(initialLocation, healthText, currencyText, regularGoblin, damage, health);
    }
}
