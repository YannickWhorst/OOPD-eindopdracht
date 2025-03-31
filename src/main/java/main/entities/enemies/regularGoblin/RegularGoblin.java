package main.entities.enemies.regularGoblin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class RegularGoblin extends DynamicCompositeEntity {

    public RegularGoblin(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var showerTowerSprite = new RegularGoblinSprite(new Coordinate2D(0, 0));
        addEntity(showerTowerSprite);

        var hitBox = new HitBox(new Coordinate2D(-10, -10));
        addEntity(hitBox);
    }
}
