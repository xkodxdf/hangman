package com.xkodxdf.app.game;

import com.xkodxdf.app.Config;
import com.xkodxdf.app.game.display.OutputText;
import com.xkodxdf.app.util.Utils;

public class Main {

    public static void main(String[] args) {
        Game game = Main.initGame();
        game.start();
    }

    public static Game initGame() {
        String initChoice;
        String initLanguage = Config.RUS_FILE_PATH;
        String startRuGame = "1";
        String startEngGame = "2";
        String exit = "3";

        System.out.println(OutputText.START_GAME_MSG);
        do {
            System.out.println(OutputText.GAME_INIT_CHOICE);
            initChoice = Utils.getInput();
            if (exit.equals(initChoice)) {
                System.exit(0);
            }
            if (startEngGame.equals(initChoice)) {
                initLanguage = Config.ENG_FILE_PATH;
                break;
            }
            if (startRuGame.equals(initChoice)) {
                break;
            }
            System.out.println(OutputText.INVALID_INPUT);
        } while (true);

        return new Game(initLanguage);
    }
}
