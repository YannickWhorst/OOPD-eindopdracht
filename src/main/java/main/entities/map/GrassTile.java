package main.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class GrassTile extends SpriteEntity {
    public GrassTile(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}
