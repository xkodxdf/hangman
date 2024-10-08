package com.xkodxdf.app.game;

import com.xkodxdf.app.game.display.Display;

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
}
