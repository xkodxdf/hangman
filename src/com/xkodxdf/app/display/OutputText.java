package com.xkodxdf.app.display;

public abstract class OutputText {
    public static final String START_GAME_MSG = "Игра Виселица\n"
            + "Цель - угадать загаданное слово по буквам. Даётся 6 попыток.\n"
            + "В словах длиной больше 7 букв - одна из букв открыта с самого начала.\n"
            + "Если вы угадали или случайно ввели букву, которую уже вводили ранее - попытка не тратится.\n";

    public static final String END_GAME_WIN_MSG = "\nИгра окончена. Вы победили, угадав слово - ";

    public static final String END_GAME_LOSS_MSG = "\nИгра окончена. Вы проиграли!\nБыло загадано слово: ";

    public static final String HIDDEN_WORD = "Загаданное слово: ";

    public static final String REMAIN = "Осталось: ";

    public static final String GUESSED_WORDS_IN_A_ROW = "  |  Угадано слов подряд: ";

    public static final String USED_LETTERS = "Буквы которые вы уже вводили: ";


    public static final String ATTEMPT_V1 = " попыток";

    public static final String ATTEMPT_V2 = " попытки";

    public static final String ATTEMPT_V3 = " попытка";

    public static final String INPUT_LETTER = "Введите букву: ";

    public static final String INVALID_LETTER_INPUT = "Неверный ввод. ";

    public static final String CONTINUE_GAME_CHOICE = "Начать новую игру - введите 1\n"
            + "Выйти - введите 2";

    public static final String INVALID_NUM_INPUT = "Некорректный ввод.\n"
            + "Введите 1 - для начала новой игры\n"
            + "Введите 2 - для завершения игры";

    public static final String FILE_LOCATION_PROBLEM = "Проверьте расположение файла \"src/resources/data.txt\"";

    public static final String FILE_CONTENT_PROBLEM = "Файл \"src/resources/data.txt\" должен содержать слова. По одному слову на каждой строке.";

    public static final String SEPARATOR = "=".repeat(60);
}
