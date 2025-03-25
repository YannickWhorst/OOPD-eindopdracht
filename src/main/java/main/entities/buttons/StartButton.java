package main.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartButton extends TextEntity {
    public StartButton(Coordinate2D initialLocation) {
        super(initialLocation, "Start");
        setFill(Color.PURPLE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
