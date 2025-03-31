package main.entities.buttons.menuButtons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import main.entities.buttons.Button;

public class LeaderboardButton extends Button {
    public LeaderboardButton(Coordinate2D initialLocation) {
        super(initialLocation, Color.PURPLE, "Leaderboard", 2);
    }
}
