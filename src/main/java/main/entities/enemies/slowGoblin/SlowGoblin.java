package main.entities.enemies.slowGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import main.entities.enemies.EnemyMoveTimer;
import main.entities.enemies.IEnemy;
import main.entities.map.GameTileMap;
import main.entities.map.tiles.TileType;

public class SlowGoblin extends DynamicCompositeEntity implements IEnemy, TimerContainer {

    private final int PATH_TILE = TileType.PATH.getId();
    private final int END_TILE = TileType.END.getId();
    private Coordinate2D previousLocation; // Houdt de vorige locatie bij

    public SlowGoblin(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var goblinSprite = new SlowGoblinSprite(new Coordinate2D(0, 0));
        addEntity(goblinSprite);
    }

    @Override
    public void takeDamage(int damage) {
        // Damage verwerken
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

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newY >= 0 && newY < map.length && newX >= 0 && newX < map[0].length &&
                    (map[newY][newX] == PATH_TILE || map[newY][newX] == END_TILE)) {

                Coordinate2D candidate = new Coordinate2D(newX * tileSize, newY * tileSize);

                if (!candidate.equals(previousLocation)) {
                    previousLocation = getAnchorLocation();
                    setAnchorLocation(candidate);
                    return;
                }
            }
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new EnemyMoveTimer(this, 1500));
    }
}
