package main.scene;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.entities.buttons.HighScoresButton;
import main.entities.buttons.QuitButton;
import main.entities.buttons.StartButton;

public class TitleScene extends StaticScene {
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/Tower_Shower_HomeScreen.jpg", true);
    }

    @Override
    public void setupEntities() {
        var towerShowerText = new TextEntity(
                new Coordinate2D(getWidth() / 2, 100),
                "Tower Shower"
        );

        towerShowerText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        towerShowerText.setFill(Color.BLUE);
        towerShowerText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(towerShowerText);

        addEntity(new StartButton(new Coordinate2D(getWidth() / 2, 200)));
        addEntity(new HighScoresButton(new Coordinate2D(getWidth() / 2, 250)));
        addEntity(new QuitButton(new Coordinate2D(getWidth() / 2, 300), Color.RED, "Afsluiten"));
    }
}
