package main.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import main.entities.map.tiles.EndTile;
import main.entities.text.HealthText;
import main.entities.map.towers.Tower;
import main.scene.GameScene;

import java.util.List;

public abstract class Hitbox extends RectangleEntity implements Collided {
    private final HealthText healthText;
    private final Enemy enemy;
    private final int damage;
    private int health;

    protected Hitbox(Coordinate2D initialLocation, HealthText healthText, Enemy enemy, int damage, int health) {
        super(initialLocation);
        this.healthText = healthText;
        this.enemy = enemy;
        this.damage = damage;
        this.health = health;
        setWidth(60);
        setHeight(60);
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        for (Collider collider : collidingObjects) {
            switch (collider) {
                case EndTile endTile -> {
                    int newHealth = GameScene.getInstance().getHealth() - this.damage;
                    healthText.setHealthText(newHealth);
                    GameScene.getInstance().setHealth(newHealth);
                    enemy.remove();
                }
                case Tower tower -> {
                    int newHealth = this.health - tower.getDamage();
                    this.health = newHealth;

                    if (newHealth <= 0) {
                        enemy.remove();
                    }
                }
                case null, default -> {
                }
            }
        }
    }
}
