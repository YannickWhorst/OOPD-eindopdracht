package main.entities.map.towers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SoapTower extends Tower {
    public SoapTower(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource, 0);
    }
}
