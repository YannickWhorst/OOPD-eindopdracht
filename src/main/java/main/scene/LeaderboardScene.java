package main.scene;

import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.entities.buttons.menuButtons.BackButton;
import main.logic.ScoreManager;

import java.util.List;

public class LeaderboardScene extends DynamicScene {

    private final ScoreManager scoreManager;

    public LeaderboardScene(ScoreManager scoreManager) {
        this.scoreManager = scoreManager;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        List<ScoreManager.ScoreEntry> topScores = scoreManager.getTopScores(10);

        TextEntity title = new TextEntity(new Coordinate2D(100, 50), "🏆 Leaderboard");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        title.setFill(Color.GOLD);
        addEntity(title);

        addEntity(new BackButton(new Coordinate2D(getWidth() / 2, getHeight() - 50), Color.BLUE, "Terug", 0));

        int yOffset = 100;
        int rank = 1;
        for (ScoreManager.ScoreEntry entry : topScores) {
            String line = rank + ". " + entry.name() + " - " + entry.score();
            TextEntity scoreText = new TextEntity(new Coordinate2D(100, yOffset), line);
            scoreText.setFill(Color.WHITE);
            scoreText.setFont(Font.font("Arial", 20));
            addEntity(scoreText);
            yOffset += 30;
            rank++;
        }
    }
}
