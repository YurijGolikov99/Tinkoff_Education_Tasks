package qaengineerweb2024;


import java.util.Scanner;

/*
Задание 5
Петя работает аналитиком в отделе, который отвечает за безопасность приложений. Недавно Петя делал сканирование паролей сотрудников на предмет уязвимостей и рассылал просьбы поменять пароли на более надежные. Некоторые из тех, кого Петя просил усилить пароль, просто взяли и удалили один символ из исходного пароля. Петю это печалит. Каждому паролю он присвоил показатель печали. Показатель печали равен числу пар символов в пароле, при удалении которых получаются одинаковые строки.
Более формально, показатель печали для строки S равен числу пар индексов і < j таких, что при удалении символа на позиции і из строки S и при удалении символа на позиции з из строки S получаются одинаковые строки.
Пете слишком грустно, поэтому он попросил посчитать показатель печали для некоторых паролей вас.

Формат входных данных
В первой строке дана длина пароля N (1 ≤ N ≤ 3 • 10^5). Во второй строке дан сам пароль - строка длины N, состоящая из маленьких букв латинского алфавита.

Формат входных данных
Выведите показатель печали для данного пароля.

Примеры данных
Пример 1
Ввод
11
paassworrrd
вывод
5

Пример 2
Ввод
6
qwerty
вывод
0
 */
public class PasswordSorrow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод длины пароля
        int N = scanner.nextInt();

        // Проверка длины пароля
        if (N < 1 || N > 3 * Math.pow(10, 5)) {
            System.out.println("Некорректная длина пароля");
            return;
        }
        // Ввод пароля
        String password = scanner.next();

        // Подсчет показателя печали
        int sadnessIndex = 0;

        // Перебор всех возможных пар индексов
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // Проверка условия удаления символов на позициях i и j
                if (password.charAt(i) == password.charAt(j)) {
                    sadnessIndex++;
                }
            }
        }

        // Вывод результата
        System.out.println(sadnessIndex);

        // Закрытие сканнера
        scanner.close();
    }
}
