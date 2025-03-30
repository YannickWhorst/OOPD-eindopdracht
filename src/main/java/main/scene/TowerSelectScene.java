package main.scene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import main.entities.buttons.menuButtons.BackButton;
import main.entities.buttons.towerButtons.ShowerTowerButton;

public class TowerSelectScene extends StaticScene {

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        addEntity(new ShowerTowerButton(new Coordinate2D(getWidth() / 2, 200), Color.BLUE, "Shower Tower"));
        addEntity(new BackButton(new Coordinate2D(new Coordinate2D(10, 10)), Color.BLUE, "Terug", 1));
    }
}
