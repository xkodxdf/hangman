package com.xkodxdf.app;

public class Test {

//
//    private final State state;
//    private final Logic logic;
//
//
//    private Game(File words) {
//        state = new State();
//        logic = new Logic(state, new Word(words.getPath()));
//    }
//
//
//    public void start() {
//        Display display = new Display();
//        while (state.isGameContinue()) {
//            while (state.isRoundContinue()) {
//                display.printGameScreen(state);
//                logic.getLetterFromUser();
//                logic.checkRoundEnd();
//            }
//            display.printEndGameMsg(state);
//            logic.askForContinue();
//        }
//    }
//
//    public static Game init() {
//        String choice;
//        final String startRuGame = "1";
//        final String startEngGame = "2";
//        final String exit = "3";
//
//        System.out.println(OutputText.START_GAME_MSG);
//        do {
//            System.out.println(OutputText.GAME_INIT_CHOICE);
//            choice = Utils.getInput();
//            switch (choice) {
//                case startRuGame:
//                    return new Game(File.RUSSIAN_WORDS);
//                case startEngGame:
//                    return new Game(File.ENGLISH_WORDS);
//                case exit:
//                    System.exit(0);
//            }
//
//            System.out.println(OutputText.INVALID_INPUT);
//        } while (true);
//    }

}
