package main.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.TowerShower;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private int scene = 0;
    private final Color color;

    public Button(Coordinate2D initialLocation, Color color, String text, int scene) {
        super(initialLocation, text);
        this.scene = scene;
        this.color = color;

        setFill(color);
        setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public Button(Coordinate2D initialLocation, Color color, String text) {
        super(initialLocation, text);
        this.color = color;

        setFill(color);
        setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        TowerShower.setScene(scene);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(color);
        setCursor(Cursor.DEFAULT);
    }
}
