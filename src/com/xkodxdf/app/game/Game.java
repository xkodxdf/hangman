package com.xkodxdf.app.game;

import com.xkodxdf.app.game.dictionary.DictionaryFile;
import com.xkodxdf.app.game.display.Display;
import com.xkodxdf.app.game.display.OutputText;
import com.xkodxdf.app.util.Utils;

public class Game {

    private final State state;
    private final Logic logic;


    private Game(DictionaryFile initDictionary) {
        state = new State();
        logic = new Logic(state, new Word(initDictionary));
    }


    public static Game init() {
        String option;
        final String startRuGame = "1";
        final String startEngGame = "2";
        final String exit = "3";

        System.out.println(OutputText.START_GAME_MSG);
        option = Utils.getOption(OutputText.GAME_INIT_CHOICE, OutputText.INVALID_INPUT,
                startRuGame, startEngGame, exit);
        switch (option) {
            case startEngGame:
                return new Game(DictionaryFile.ENGLISH_WORDS);
            case exit:
                System.exit(0);
            default:
                return new Game(DictionaryFile.RUSSIAN_WORDS);
        }
    }

    public void start() {
        Display display = new Display();
        while (state.isGameContinue()) {
            while (state.isRoundContinue()) {
                display.printGameScreen(state);
                logic.inputLetter();
                logic.changeIsRoundContinue();
            }
            display.printEndGameMsg(state);
            logic.changeIsGameContinue();
        }
    }
}
