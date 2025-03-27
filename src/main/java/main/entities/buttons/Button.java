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

public class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final TowerShower towerShower;
    private final int scene;
    private final Color color;

    public Button(Coordinate2D initialLocation, TowerShower towerShower, Color color, String text, int scene) {
        super(initialLocation, text);
        this.towerShower = towerShower;
        this.scene = scene;
        this.color = color;

        setFill(color);
        setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        this.towerShower.setActiveScene(scene);
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
