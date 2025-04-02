package main.scene;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.entities.buttons.menuButtons.LeaderboardButton;
import main.entities.buttons.menuButtons.QuitButton;
import main.entities.buttons.menuButtons.HomeButton;

public class GameOverScene extends StaticScene {

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/Tower_Shower_GameOver.jpg", true);
    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, 100),
                "Game Over"
        );

        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.RED);
        gameOverText.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        addEntity(gameOverText);

        // Knoppen
        addEntity(new LeaderboardButton(new Coordinate2D(getWidth() / 2, 250)));
        addEntity(new HomeButton(new Coordinate2D(getWidth() / 2, 300)));
        addEntity(new QuitButton(new Coordinate2D(getWidth() / 2, 350), Color.RED, "Afsluiten"));
    }
}
