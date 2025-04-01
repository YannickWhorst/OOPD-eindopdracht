package main.entities.enemies.slowGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import main.entities.enemies.EnemyMoveTimer;
import main.entities.enemies.IEnemy;
import main.entities.enemies.slowGoblin.SlowGoblinSprite;
import main.entities.map.GameTileMap;

public class SlowGoblin extends DynamicCompositeEntity implements IEnemy, TimerContainer {

    private EnemyMoveTimer moveTimer;
    private Coordinate2D previousLocation; // Houdt de vorige locatie bij

    public SlowGoblin(Coordinate2D initialLocation) {
        super(initialLocation);
        moveTimer = new EnemyMoveTimer(this, 2000);
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
        Coordinate2D newLocation = null;

        // Controleer omliggende tiles en vermijd teruggaan
        if (y > 0 && map[y - 1][x] == 8) { // Boven
            Coordinate2D candidate = new Coordinate2D(x * tileSize, (y - 1) * tileSize);
            if (!candidate.equals(previousLocation)) {
                newLocation = candidate;
            }
        }
        if (x < map[0].length - 1 && map[y][x + 1] == 8) { // Rechts
            Coordinate2D candidate = new Coordinate2D((x + 1) * tileSize, y * tileSize);
            if (!candidate.equals(previousLocation)) {
                newLocation = candidate;
            }
        }
        if (y < map.length - 1 && map[y + 1][x] == 8) { // Onder
            Coordinate2D candidate = new Coordinate2D(x * tileSize, (y + 1) * tileSize);
            if (!candidate.equals(previousLocation)) {
                newLocation = candidate;
            }
        }
        if (x > 0 && map[y][x - 1] == 8) { // Links
            Coordinate2D candidate = new Coordinate2D((x - 1) * tileSize, y * tileSize);
            if (!candidate.equals(previousLocation)) {
                newLocation = candidate;
            }
        }

        // Update de locatie als er een geldige beweging is
        if (newLocation != null && !newLocation.equals(previousLocation)) {
            previousLocation = getAnchorLocation();
            setAnchorLocation(newLocation);
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new EnemyMoveTimer(this, 1000));
    }
}
