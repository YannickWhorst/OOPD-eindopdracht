package main.scene;

public class WinScene extends GameEndScene {

    public WinScene() {
        super("backgrounds/Tower_Shower_WinScreen.jpg", "Je hebt gewonnen!", GameScene.getInstance().getScoreManager());
    }

}
