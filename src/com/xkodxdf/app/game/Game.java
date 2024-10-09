package com.xkodxdf.app.game;

import com.xkodxdf.app.Config;
import com.xkodxdf.app.game.display.Display;
import com.xkodxdf.app.game.display.OutputText;
import com.xkodxdf.app.util.Utils;

public class Game {

    private final State state;
    private final Logic logic;
    private final Display display;


    public Game(String initLanguage) {
        state = new State();
        display = new Display(state);
        logic = new Logic(state, new Word(initLanguage));
    }


    public void start() {
        while (state.isGameContinue()) {
            while (state.isRoundContinue()) {
                display.printGameScreen();
                logic.getLetterFromUser();
                logic.checkRoundEnd();
            }
            display.printEndGameMsg();
            logic.askForContinue();
        }
    }

    public static String getStartLanguage() {
        String choice;
        String startLanguage = Config.RUS_FILE_PATH;
        String startRuGame = "1";
        String startEngGame = "2";
        String exit = "3";

        System.out.println(OutputText.START_GAME_MSG);
        do {
            System.out.println(OutputText.GAME_INIT_CHOICE);
            choice = Utils.getInput();
            if (exit.equals(choice)) {
                System.exit(0);
            }
            if (startEngGame.equals(choice)) {
                startLanguage = Config.ENG_FILE_PATH;
                break;
            }
            if (startRuGame.equals(choice)) {
                break;
            }
            System.out.println(OutputText.INVALID_INPUT);
        } while (true);

        return startLanguage;
    }
}
