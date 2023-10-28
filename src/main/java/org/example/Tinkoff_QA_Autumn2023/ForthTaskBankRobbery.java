package org.example.Tinkoff_QA_Autumn2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ForthTaskBankRobbery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Необходимая сумма
        int m = scanner.nextInt(); // Количество номиналов купюр

        if (n < 1 || n > Math.pow(10, 9)) {
            System.out.println("Недопустимая необходимая ковбою сумма купюр.");
            return;
        } else if (m < 1 || m > 10) {
            System.out.println("Недопустимое необходимое ковбою количество номиналов купюр.");
            return;
        }

        // Чтение номиналов купюр
        int[] denominations = new int[m];
        for (int i = 0; i < m; i++) {
            denominations[i] = scanner.nextInt();
            if (denominations[i] < 1 || denominations[i] > Math.pow(10, 9)) {
                System.out.println("Не верные оминалы купюр");
                return;
            }
        }

        // Создаем список для хранения украденных купюр
        List<Integer> stolenNotes = new ArrayList<>();

        // Сортируем номиналы купюр в убывающем порядке
        Arrays.sort(denominations);
        for (int i = m - 1; i >= 0; i--) {
            int currentDenomination = denominations[i];

            // Пока сумма не превышает n и в банке остались купюры данного номинала
            while (n - currentDenomination >= 0) {
                stolenNotes.add(currentDenomination);
                n -= currentDenomination;
            }
        }

        if (n == 0) {
            // Если удалось украсть все необходимые деньги
            System.out.println(stolenNotes.size());
            for (int note : stolenNotes) {
                System.out.print(note + " ");
            }
        } else {
            // Если не удалось найти комбинацию купюр
            System.out.println("-1");
        }
    }
}

/*
На Диком западе ходят купюры номиналами a1,a2,…,am долларов. Однажды ковбой Джо решил ограбить банк. Он выбрал очень неудачный момент для ограбления, ведь сейчас в банке находятся ровно по две купюры каждого существующего номинала.

Ковбой Джо хочет украсть ровно n долларов, ни долларом больше, ни долларом меньше. Помогите ему или сообщите, что его план неосуществим.

Формат входных данных
В первой строке даны целые числа n,m (1≤n≤10^9, 1≤m≤10) — необходимая ковбою Джо сумма и количество номиналов купюр.
Во второй строке вводятся m попарно различных целых чисел a1,a2,…,am (1≤ai≤10^9) —
существующие номиналы купюр.

Формат выходных данных
Если ковбой Джо сможет украсть ровно n долларов, выведите число k — количество украденных купюр. Затем выведите k целых чисел — номиналы купюр. Если решений несколько, вы можете вывести любое.

В противном случае выведите −1.
Примеры данных
Пример 1
ввод
5 2
1 2
вывод
3
1 2 2

Пример 2
ввод
7 2
1 2
вывод
-1

Пример 3
ввод
5 2
3 4
вывод
-1
 */
