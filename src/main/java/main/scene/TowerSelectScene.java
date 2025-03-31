package main.scene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import main.entities.buttons.Button;
import main.entities.buttons.menuButtons.BackButton;
import main.entities.buttons.towerButtons.BathtubTowerButton;
import main.entities.buttons.towerButtons.ShowerTowerButton;
import main.entities.map.tiles.TowerTile;

public class TowerSelectScene extends DynamicScene {

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        Button showerTowerButton =
                new ShowerTowerButton(new Coordinate2D(getWidth() / 2, 200), Color.BLUE, "Shower Tower", TowerTile.getTileX(), TowerTile.getTileY());
        addEntity(showerTowerButton);

        Button bathtubTowerButton =
                new BathtubTowerButton(new Coordinate2D(getWidth() / 2, 250), Color.BLUE, "Bathtub Tower", TowerTile.getTileX(), TowerTile.getTileY());
        addEntity(bathtubTowerButton);

        Button backButton =
                new BackButton(new Coordinate2D(new Coordinate2D(35, 15)), Color.BLUE, "Terug", 1);
        addEntity(backButton);
    }
}
