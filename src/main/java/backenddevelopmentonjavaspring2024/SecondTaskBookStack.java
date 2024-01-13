package backenddevelopmentonjavaspring2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Заяц Миша очень любит читать, поэтому на новый год ему подарили n книг.
Михаил хочет сложить компактно все подаренные книги в несколько стопок. Заяц считает, что книги сложены в стопки красиво, если в каждой стопке все книги имеют одинаковую высоту.
Миша хочет сложить книги в минимальное число стопок так, чтобы книги были сложены красиво.
Помогите ему и найдите, как нужно сложить книги в стопки.

Формат входных данных
В первой строке входных данных дано целое число n — число книг, подаренных Зайцу (1 <= n <= 10^5).
Во второй строке дано п целых чисел x_1, ..., Х_n — высоты книг (1 <= x_i<= 10^5).

Формат выходных данных
В первой строке вывода напечатайте одно число k — минимальное число стопок книг.
Во второй строке выведите высоты стопок книг в порядке неубывания.

Замечание
Обратите внимание, что в ответе нужно вывести высоты стопок книг, а не высоты книг в стопках.
В первом примере из условия Миша может сложить книги в две стопки, высота каждой из стопок будет равна 1.
Во втором примере из условия Миша может сложить книги в три стопки: в первой будут одна книга с высотой 1, во второй одна книга с высотой 3, в третьей - две книги с высотой 2.

Примеры данных
Пример 1
Ввод
2
1 2
Вывод
2
1 1

Пример 2
Ввод
4
1 2 2 3
Вывод
3
1 1 2

Пример 3
Ввод
5
5 4 4 5 5
Вывод
2
2 3

 */
public class SecondTaskBookStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Число книг
        int n = scanner.nextInt();
        int[] bookHeights = new int[n];

        // Высоты книг
        for (int i = 0; i < n; i++) {
            bookHeights[i] = scanner.nextInt();
        }

        scanner.close();

        Arrays.sort(bookHeights); // Сортируем массив высот книг

        Map<Integer, Integer> stackHeights = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int currentHeight = bookHeights[i];
            stackHeights.put(currentHeight, stackHeights.getOrDefault(currentHeight, 0) + 1);
        }

        System.out.println(stackHeights.size());
        stackHeights.values().forEach(height -> System.out.print(height + " "));
    }
}