package qaautumn2023;

import java.util.Arrays;
import java.util.Scanner;

public class ThirdTaskCowboyCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // Вывести "NO", так как n не находится в допустимом диапазоне
        if (n < 1 || n > 2 * Math.pow(10, 5)) {
            System.out.println("Не допустимое количество карт в последовательности");
            return;
        }

        int[] a = new int[n];
        int[] b = new int[n];

        //Последовательность ковбоя Джо
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] < 1 || a[i] > Math.pow(10, 9)) {
                System.out.println("Последовательность ковбоя находится в недопустимом диапазоне");
                return;
            }
        }

        //Выигрышная последовательность
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
            if (b[i] < 1 || b[i] > Math.pow(10, 9)) {
                System.out.println("Выигрышная последовательность находится в недопустимом диапазоне");
                return;
            }
        }

        int left = 0;
        int right = n - 1;

        // Найдем первое и последнее местоположение, где последовательности a и b различаются
        while (left < n && a[left] == b[left]) {
            left++;
        }
        while (right >= 0 && a[right] == b[right]) {
            right--;
        }

        // Проверим, можно ли упорядочить подпоследовательность a[left:right+1] так, чтобы она стала идентичной b[left:right+1]
        int[] sortedA = a.clone();
        Arrays.sort(sortedA, left, right + 1);

        for (int i = left; i <= right; i++) {
            if (sortedA[i] != b[i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
/*
Перед ковбоем Джо выложены n карт со значениями a1,a2,…,an. Он хочет получить выигрышную последовательность карт со значениями b1,b2,…,bn.

Ковбой может выбрать непрерывный отрезок карт в своей последовательности [l,r] (1≤l≤r≤n) и упорядочить карты в этом отрезке по неубыванию. Например, если перед ковбоем лежат карты {3,3,2,5,1,5}, он может выбрать отрезок [2,5] и получить последовательность {3,1,2,3,5,5}.

Получится ли у ковбоя Джо получить выигрышную последовательность с помощью применения выше описанной операции ровно один раз?

Формат входных данных
В первой строке дано целое число n (1≤n≤2⋅10^5) — количество карт в последовательности.
Во второй строке даны n целых чисел a1,a2,…,an (1≤ai≤10^9) — последовательность ковбоя Джо.
В третьей строке даны n целых чисел b1,b2,…,bn (1≤bi≤10^9) — выигрышная последовательность.

Формат выходных данных
Выведите «YES» (без кавычек), если Джо может получить выигрышную последовательность, иначе выведите «NO».

Примеры данных
Пример 1
ввод
5
1 4 2 2 4
1 4 4 2 2
вывод
NO

Пример 2
ввод
6
5 1 2 5 3 5
5 1 2 3 5 5
вывод
YES

Пример 3
ввод
3
4 1 2
1 4 7
вывод
NO

Пример 4
ввод
1
7
7
вывод
YES

Пример 5
ввод
7
4 4 1 7 5 3 8
4 1 4 5 7 3 8
вывод
YES
 */