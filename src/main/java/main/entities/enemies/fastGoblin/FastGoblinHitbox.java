package main.entities.enemies.fastGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import main.entities.enemies.Hitbox;
import main.entities.text.HealthText;

public class FastGoblinHitbox extends Hitbox {
    public FastGoblinHitbox
            (Coordinate2D initialLocation, HealthText healthText, FastGoblin goblin, int damage, int health) {
        super(initialLocation, healthText, goblin, damage, health);
    }
}
