package main.scene;


public class GameOverScene extends GameEndScene {

    public GameOverScene() {
        super("backgrounds/Tower_Shower_GameOver.jpg", "Game Over!", GameScene.getInstance().getScoreManager());
    }

}
