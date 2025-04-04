package main.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import main.entities.map.tiles.EndTile;
import main.entities.map.tiles.PassedTowerTile;
import main.entities.text.CurrencyText;
import main.entities.text.HealthText;
import main.entities.map.towers.Tower;
import main.scene.GameScene;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Hitbox extends RectangleEntity implements Collided {
    private final HealthText healthText;
    private final CurrencyText currencyText;
    private final Enemy enemy;
    private final int damage;
    private int health;
    private Timer damageTimer;
    private boolean isCollidingWithTower = false;

    protected Hitbox(Coordinate2D initialLocation, HealthText healthText, CurrencyText currencyText, Enemy enemy, int damage, int health) {
        super(initialLocation);
        this.healthText = healthText;
        this.currencyText = currencyText;
        this.enemy = enemy;
        this.damage = damage;
        this.health = health;
        setWidth(60);
        setHeight(60);
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        boolean isCollidingWithTower = false;

        for (Collider collider : collidingObjects) {
            switch (collider) {
                case EndTile ignored -> {
                    int newHealth = GameScene.getInstance().getHealth() - this.damage;
                    healthText.setHealthText(newHealth);
                    GameScene.getInstance().setHealth(newHealth);
                    enemy.remove();
                }
                case Tower tower -> {
                    isCollidingWithTower = true;
                    if (!this.isCollidingWithTower) {
                        startDamageTimer(tower);
                    }
                }
                case PassedTowerTile ignored -> stopDamageTimer();
                case null, default -> {
                }
            }
        }

        this.isCollidingWithTower = isCollidingWithTower;
    }

    private void startDamageTimer(Tower tower) {
        if (damageTimer != null) {
            stopDamageTimer();
        }

        damageTimer = new Timer();
        damageTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (isCollidingWithTower) {
                    takeDamage(tower);
                } else {
                    stopDamageTimer();
                }
            }
        }, 0, 1000);
    }

    public void takeDamage(Tower tower) {
        int newHealth = this.health - tower.getDamage();
        this.health = newHealth;

        if (newHealth <= 0) {
            int newCurrency = GameScene.getInstance().getCurrency() + 50;
            this.currencyText.setCurrencyText(newCurrency);
            GameScene.getInstance().setCurrency(newCurrency);
            stopDamageTimer();
            enemy.remove();
            GameScene.getInstance().enemyKilled();
            System.out.println("" + GameScene.getInstance().getEnemyCount());
            // Controleer of er nog vijanden over zijn
            if (GameScene.getInstance().getEnemyCount() == 0) {
                Platform.runLater(() -> GameScene.getInstance().goToWinScene());

//                GameScene.getInstance().goToWinScene();
            }
        }
    }

    private void stopDamageTimer() {
        if (damageTimer != null) {
            damageTimer.cancel();
            damageTimer = null;
        }
    }
}
