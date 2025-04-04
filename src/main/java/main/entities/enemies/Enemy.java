package main.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import main.entities.map.GameTileMap;
import main.entities.map.tiles.TileType;
import main.entities.text.CurrencyText;
import main.entities.text.HealthText;
import main.timers.EnemyMoveTimer;

public abstract class Enemy extends DynamicCompositeEntity implements TimerContainer {
    protected Coordinate2D previousLocation;
    protected final int PATH_TILE = TileType.PATH.getId();
    protected final int END_TILE = TileType.END.getId();
    protected final int PASSED_TOWER_TILE = TileType.PASSED_TOWER.getId();
    protected final HealthText healthText;
    protected final CurrencyText currencyText;
    protected final int interval;

    protected Enemy(Coordinate2D initialLocation, HealthText healthText, CurrencyText currencyText, int interval) {
        super(initialLocation);
        this.healthText = healthText;
        this.currencyText = currencyText;
        this.interval = interval;
    }

    @Override
    protected abstract void setupEntities();

    public void moveEnemy() {
        int tileSize = 40;
        int x = (int) getAnchorLocation().getX() / tileSize;
        int y = (int) getAnchorLocation().getY() / tileSize;

        int[][] map = GameTileMap.getInstance().defineMap();
        int[][] directions = {
                {0, -1},  // Up
                {1, 0},   // Right
                {0, 1},   // Down
                {-1, 0}   // Left
        };

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newY >= 0 && newY < map.length && newX >= 0 && newX < map[0].length &&
                    (map[newY][newX] == PATH_TILE || map[newY][newX] == END_TILE || map[newY][newX] == PASSED_TOWER_TILE)) {
                Coordinate2D location = new Coordinate2D(newX * tileSize, newY * tileSize);

                if (location.equals(previousLocation)) {
                    continue;
                }

                previousLocation = getAnchorLocation();
                setAnchorLocation(location);
                return;
            }
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new EnemyMoveTimer(this, this.interval));
    }
}