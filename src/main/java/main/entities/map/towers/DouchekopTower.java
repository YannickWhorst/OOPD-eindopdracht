package main.entities.map.towers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class DouchekopTower extends Tower {
    public DouchekopTower(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource, 15);
    }
}
