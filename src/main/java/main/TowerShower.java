package main;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import main.scene.*;

public class TowerShower extends YaegerGame {
    private static TowerShower instance;

    public static void main(String[] args) {
        launch(args);
    }

    public TowerShower() {
        instance = this;
    }

    public static void setScene(int sceneId) {
        if (instance != null) {
            instance.setActiveScene(sceneId);
        }
    }

    public static void quitGame() {
        instance.quit();
    }

    @Override
    public void setupGame() {
        setGameTitle("Tower Shower");
        setSize(new Size(800, 800));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene());
        addScene(1, GameScene.getInstance());
        addScene(2, new LeaderboardScene(GameScene.getInstance().getScoreManager()));
        addScene(3, new GameOverScene());
        addScene(4, new WinScene());
    }
}
