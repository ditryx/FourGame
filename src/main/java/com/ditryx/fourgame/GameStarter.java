package com.ditryx.fourgame;

public class GameStarter {

    public static FourGame fourGame;

    public static void main(String[] args) {
        fourGame = new FourGame();
        fourGame.run();
    }

}
