package main.scene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

public class GameOverScene extends StaticScene {
    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        addEntity(new TextEntity(new Coordinate2D(0, 0), "Game Over"));
    }
}
