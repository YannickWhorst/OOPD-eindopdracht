package main;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class TowerShower extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void setupGame() {
        setGameTitle("Tower Shower");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {

    }
}
