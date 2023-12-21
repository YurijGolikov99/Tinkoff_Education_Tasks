package Tinkoff_QA_Autumn2023;

import java.util.Scanner;

public class SecondTaskSheriffHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        // Проверка длины строки на соответствие диапазону

        if (s.length() < 1 || s.length() > 2 * Math.pow(10, 5)) {
            System.out.println("Длина строки находится вне допустимого диапазона.");
            return;
            // Проверка на наличие заглавных бук
        } else if (!s.equals(s.toLowerCase())) {
            System.out.println("Строка должна содержать только маленькие буквы латинского алфавита.");
            return;
        }

        int[] letterCount = new int[26]; // Для хранения количества каждой буквы

        // Подсчитываем количество каждой буквы в строке s
        for (char c : s.toCharArray()) {
            letterCount[c - 'a']++;
        }

        // Буквы в слове "sheriff"
        String targetWord = "sheriff";

        int maxSheriffCount = Integer.MAX_VALUE;

        // Находим минимальное количество вхождений букв из "sheriff" в строку s
        for (char c : targetWord.toCharArray()) {
            int requiredCount = letterCount[c - 'a'];
            maxSheriffCount = Math.min(maxSheriffCount, requiredCount);
        }

        // Выводим результат
        System.out.println(maxSheriffCount);
    }
}

/*
Однажды ковбой Джо нанялся в помощники шерифу. Шериф выдал ковбою Джо строку s и попросил собрать из её букв как можно больше слов sheriff. Каждая буква может использоваться не более одного раза.
Ковбой Джо тут же приступил к заданию шерифа, но к сожалению, он не умеет читать. Помогите ковбою Джо.
Формат входных данных
Дана строка s (1≤∣s∣≤2⋅10^5) состоящая из маленьких букв латинского алфавита.
Формат выходных данных
Выведите максимальное количество слов sheriff, которое можно собрать из букв строки s.
Примеры данных
Пример 1
ввод fheriherffazfszkisrrs
вывод 2

Пример 2
ввод rifftratatashe
вывод 1

Пример 3
ввод thegorillaiswatching
вывод 0
 */