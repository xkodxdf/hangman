package com.xkodxdf.app.game.display;

public final class OutputText {

    public static final String END_GAME_WIN_MSG = "\nИгра окончена. Вы победили, угадав слово:\n";

    public static final String END_GAME_LOSS_MSG = "\nИгра окончена. Вы проиграли!\nБыло загадано слово: ";

    public static final String HIDDEN_WORD = "Загаданное слово: ";

    public static final String ATTEMPTS_REMAINED = "Осталось попыток: ";

    public static final String GUESSED_WORDS_IN_A_ROW = " | Угадано слов подряд: ";

    public static final String USED_LETTERS = "Буквы которые вы уже вводили: ";

    public static final String INPUT_LETTER = "#Введите букву: ";

    public static final String INVALID_INPUT = "Неверный ввод. ";

    public static final String RU_LANG = " | Язык: русский";

    public static final String ENG_LANG = " | Язык: английский";

    public static final String FILE_LOCATION_PROBLEM = "Файл по указанному пути не найден. "
            + "Проверьте расположение файла и перезапустите программу: ";

    public static final String OR_INPUT_FILE_PATH = "\nИли введите путь к корректному файлу в формате: ";

    public static final String FILE_CONTENT_PROBLEM = " файл должен содержать слова в формате - слово:значение.\n"
            + "Проверьте содержимое файла." + OR_INPUT_FILE_PATH;

    public static final String INPUT_FILE_PATH_OR_EXIT = "\n#Введите 1 = чтобы указать путь к файлу\n"
            + "#Введите 2 - чтобы выйти";

    public static String PATH_TO_FILE = "Путь к файлу: ";

    public static final String START_GAME_MSG = "=Игра Виселица=\n"
            + "Цель - угадать загаданное слово по буквам. Даётся " + (HangmanImage.values().length - 1) + " попыток.\n"
            + "В словах длиной больше 7 букв - одна из букв открыта с самого начала"
            + "(только одна, даже если в слове несколько таких букв).\n"
            + "Если вы угадали или случайно ввели букву, которую уже вводили ранее - попытка не тратится.\n";

    public static final String GAME_INIT_CHOICE = "#Введите 1 - начать игру с русскими словами.\n"
            + "#Введите 2 - начать игру с английскими словами.\n"
            + "#Введите 3 - выйти.";

    public static final String CONTINUE_GAME_CHOICE = "#Введите 1 - начать новую игру.\n"
            + "#Введите 2 - сменить язык словаря и начать новую игру.\n"
            + "#Введите 3 - выйти.";

    public static final String INVALID_NUM_INPUT = INVALID_INPUT
            + "\n#Введите 1 - для начала новой игры.\n"
            + "#Введите 2 - для смены языка\n"
            + "#Введите 3 - для завершения игры.";

    public static final String SEPARATOR = "\n" + "=".repeat(80);


    private OutputText() {
    }
}
