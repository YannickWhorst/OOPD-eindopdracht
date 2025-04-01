package main.entities.enemies.fastGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import main.entities.map.tiles.EndTile;
import main.entities.text.HealthText;
import main.scene.GameScene;

import java.util.List;

public class HitBox extends RectangleEntity implements Collided {
    private final HealthText healthText;
    private final FastGoblin goblin;

    protected HitBox(Coordinate2D initialLocation, HealthText healthText, FastGoblin goblin) {
        super(initialLocation);
        this.healthText = healthText;
        this.goblin = goblin;
        setWidth(60);
        setHeight(60);
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        for (Collider collider : collidingObjects) {
            if (collider instanceof EndTile) {
                int newHealth = GameScene.getInstance().getHealth() - 1;
                healthText.setHealthText(newHealth);
                GameScene.getInstance().setHealth(newHealth);
                goblin.remove();
            }
        }
    }
}
