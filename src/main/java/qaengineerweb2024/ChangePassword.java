package qaengineerweb2024;

import java.util.Scanner;

/*
Задача 1
Вите пришло уведомление от его менеджера паролей, что его пароли засветились в интернете и не являются надежными. Недолго думая, Витя решил массово исправить все пароли. Пароль представляет из себя строку S из маленьких латинских букв длины N. Чтобы изменить пароль, Витя выбирает две позиции в строке — а и b — и меняет элементы на позициях а и b местами.
Так как паролей много, Витя попросил вас написать программу, которая по заданным S, а, b будет генерировать новый пароль. Помогите Вите!

Формат входных данных
В первой строке задается пароль, который хочет поменять Витя, — S — строка длины N(1 ≤ N ≤ 200) . Во второй строке через пробел записаны числа а и b (1 ≤ a ≤ b ≤ N).

Формат выходных данных
Выведите единственную строку — новый пароль, полученный из S перестановкой символов.

Примеры данных
ввод
tifkofn
3 7
вывод
tinkoff
 */
public class ChangePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод пароля
        String password = scanner.nextLine();

        // Проверка длины пароля
        if (password.length() <= 1 || password.length() >= 200) {
            System.out.println("Некорректная длина пароля.");
            return;
        }

        // Ввод позиций a и b
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // Проверка корректности ввода позиций
        if (a < 1 || b < a || password.length() < b) {
            System.out.println("Некорректные позиции чисел.");
            return;
        }

        // Преобразование строки в массив символов для удобства манипуляций
        char[] passwordArray = password.toCharArray();

        // Обмен символов на позициях a и b
        char temp = passwordArray[a - 1];
        passwordArray[a - 1] = passwordArray[b - 1];
        passwordArray[b - 1] = temp;

        // Вывод результата
        System.out.println(new String(passwordArray));

        // Закрытие сканнера
        scanner.close();
    }
}
