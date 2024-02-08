package qaengineerweb2024;

import java.util.Arrays;
import java.util.Scanner;

/*
Задание 7
Алина — начинающий мобильный разработчик. Она получила задание сделать экран по макету от дизайнера. Дизайнер то ли начинающий, то ли слишком опытный, макеты были несколько странные.
К счастью, Алина поняла, как итеративно построить экран по этому макету.
Экран представляет собой прямоугольник А пикселей в высоту и В пикселей в ширину. Алина будет рисовать на экране полосы во весь экран, заполняющие либо полный ряд пикселей, либо полный столбец пикселей цветом с. Если какие-то клетки столбца или ряда уже были покрашены в какой-то цвет, то они перекрашиваются в цвет с. Изначально экран заполнен цветом 0 (черный), Алина этим цветом рисовать не планирует.
Таких операций Алина сделает N штук и после этого получит желаемый экран. Но теперь ей стало интересно, сколько после таких операций на экране окажется пикселей каждого цвета. Помогите Алине!

Формат входных данных
В первой строке даны размеры экрана - А и В (1 ≤ А ≤ В ≤ 10^9), число используемых цветов N (1 ≤ N ≤ 3 • 10^5) и количество полос, которые нарисовала Алина, Q (1 ≤ Q ≤ 3 • 10^5).
В следующих Q строках даны полосы, которые нарисовала Алина, в порядке их появления. Каждая полоса задается тройкой чисел: type n color, где type = 1 в случае, если закрашивалась строка, и type = 2, если это был столбец. n обозначает порядковый номер строки или столбца (1 ≤ n ≤ A или 1 ≤ n ≤ В в зависимости от того, работаем мы со столбцом или строкой), color — используемый цвет (1 < color ≤ N).

Формат выходных данных
Выведите для каждого цвета от 1 до N, сколько пикселей будут в него покрашены в конце.
Примеры данных
Пример 1
Ввод
4 6 5 7
1 1 1
2 2 4
1 3 3
2 4 2
1 1 2
1 1 5
2 1 3
вывод
0 3 8 2 5

Пример 2
Ввод
500000000 500000000 3 5
1 1 2
1 2 3
1 3 3
1 4 3
1 5 3
Вывод
0 500000000 2000000000
 */
public class Screen {
    private final int[][] pixels;
    private final int height;
    private final int width;

    public Screen(int height, int width) {
        this.height = height;
        this.width = width;
        this.pixels = new int[height][width];
    }

    // Метод для рисования полосы по горизонтали
    public void drawHorizontalStripe(int row, int color) {
        Arrays.fill(pixels[row - 1], color);
    }

    // Метод для рисования полосы по вертикали
    public void drawVerticalStripe(int col, int color) {
        for (int i = 0; i < height; i++) {
            pixels[i][col - 1] = color;
        }
    }

    // Метод для подсчета количества пикселей каждого цвета
    public int[] countPixels() {
        int[] colorCount = new int[300000]; // Максимальное количество цветов N = 3 • 10^5
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int color = pixels[i][j];
                if (color != 0) {
                    colorCount[color]++;
                }
            }
        }
        return colorCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = scanner.nextInt();
        int width = scanner.nextInt();

        // Проверка на ввод размеров экрана
        if (height < 1 || width < height || width > Math.pow(10, 9)) {
            System.out.println("Некорректные размеры экрана.");
            return;
        }

        int numColors = scanner.nextInt();

        // Проверка на ввод числа используемых цветов
        if (numColors < 1 || numColors > 3 * Math.pow(10, 5)) {
            System.out.println("Некорректное количество цветов.");
            return;
        }

        int numStripes = scanner.nextInt();

        // Проверка на ввод количества полос
        if (numStripes < 1 || numStripes > 3 * Math.pow(10, 5)) {
            System.out.println("Некорректное количество полос.");
            return;
        }

        Screen screen = new Screen(height, width);

        for (int i = 0; i < numStripes; i++) {
            int type = scanner.nextInt();
            int n = scanner.nextInt();
            int color = scanner.nextInt();

            if (type == 1) {
                screen.drawHorizontalStripe(n, color);
            } else if (type == 2) {
                screen.drawVerticalStripe(n, color);
            }
        }

        // Подсчет количества пикселей каждого цвета
        int[] colorCount = screen.countPixels();

        // Вывод результатов
        for (int i = 1; i <= numColors; i++) {
            System.out.print(colorCount[i] + " ");
        }
    }
}
