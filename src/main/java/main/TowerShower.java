package main;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import main.scene.GameScene;
import main.scene.HighScoreScene;
import main.scene.TitleScene;

public class TowerShower extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Tower Shower");
        setSize(new Size(800, 800));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameScene());
        addScene(2, new HighScoreScene());
    }
}
