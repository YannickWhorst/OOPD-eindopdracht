package main.scene;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.entities.buttons.menuButtons.HomeButton;
import main.entities.buttons.menuButtons.LeaderboardButton;
import main.entities.buttons.menuButtons.QuitButton;
import main.logic.ScoreManager;

public abstract class GameEndScene extends StaticScene {
    private final String resource;
    private final String text;
    private final ScoreManager scoreManager;


    public GameEndScene(String resource, String text, ScoreManager scoreManager) {
        this.resource = resource;
        this.text = text;
        this.scoreManager = scoreManager;
    }

    @Override
    public void setupScene() {
        setBackgroundImage(this.resource, true);
    }

    @Override
    public void setupEntities() {
        scoreManager.saveScore("Speler");

        var text = new TextEntity(
                new Coordinate2D(getWidth() / 2, 100),
                this.text
        );

        text.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        text.setFill(Color.DARKBLUE);
        text.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        addEntity(text);

        addEntity(new LeaderboardButton(new Coordinate2D(getWidth() / 2, 250)));
        addEntity(new HomeButton(new Coordinate2D(getWidth() / 2, 300)));
        addEntity(new QuitButton(new Coordinate2D(getWidth() / 2, 350), Color.RED, "Afsluiten"));
    }
}
