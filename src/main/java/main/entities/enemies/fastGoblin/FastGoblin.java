package main.entities.enemies.fastGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import main.entities.enemies.EnemyMoveTimer;
import main.entities.enemies.IEnemy;
import main.entities.map.GameTileMap;
import main.entities.map.tiles.TileType;
import main.entities.text.HealthText;

public class FastGoblin extends DynamicCompositeEntity implements IEnemy, TimerContainer {

    private Coordinate2D previousLocation;
    private final int PATH_TILE = TileType.PATH.getId();
    private final int END_TILE = TileType.END.getId();
    private final HealthText healthText;

    public FastGoblin(Coordinate2D initialLocation, HealthText healthText) {
        super(initialLocation);
        this.healthText = healthText;
    }

    @Override
    protected void setupEntities() {
        var goblinHitbox = new HitBox(new Coordinate2D(-10, -10), healthText, this);
        addEntity(goblinHitbox);
        var goblinSprite = new FastGoblinSprite(new Coordinate2D(0, 0));
        addEntity(goblinSprite);
    }

    @Override
    public void takeDamage(int damage) {

    }

    @Override
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
                    (map[newY][newX] == PATH_TILE || map[newY][newX] == END_TILE)) {
                Coordinate2D candidate = new Coordinate2D(newX * tileSize, newY * tileSize);

                if (candidate.equals(previousLocation)) {
                    continue;
                }

                previousLocation = getAnchorLocation();
                setAnchorLocation(candidate);
                return;
            }
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new EnemyMoveTimer(this, 500));
    }
}
