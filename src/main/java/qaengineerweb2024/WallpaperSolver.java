package qaengineerweb2024;

import java.util.Arrays;
import java.util.Scanner;

/*
Задача 3
Маша решила обновить интерьер своей комнаты и поменять на одной из стен обои. У неё есть неограниченное число рулонов ширины W сантиметров. Для определённости Маша клеит обои полосами вида (х, х + W], где х — число сантиметров, начиная от края стены, где начинается полоса обоев, а х + W - где заканчивается. По высоте полоса всегда начинается у пола и заканчивается у потолка. Маша уже наклеила обои в некоторых местах, координаты х этих участков известны. Ширина стены в сантиметрах составляет L.
Сейчас Маша убегает на хакатон и поэтому просит доклеить обои вас. Ваша задача — покрыть все оставшиеся участки стены обоями так, чтобы израсходовать минимальное число полос обоев.

Формат входных данных
В первой строке дано число полос, которые Маша успела наклеить, N (1 ≤ N < 10^5), ширина стены L (1 ≤ L ≤ 10^18) и ширина рулона обоев W (1 ≤ W < L). Во второй строке даны х_i — координаты левых концов наклеенных полос в порядке возрастания (0 ≤ x_i < L - W). Наклеенные полосы могут пересекаться.

Формат выходных данных
Выведите единственное число - минимальное число полос, которого хватит на оклейку оставшихся участков стены.

Примеры данных
Пример 1
Ввод
1 5 1
3
Вывод
4

Пример 2
Ввод
2 7 3
0 4
Вывод
1
 */
public class WallpaperSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // количество наклеенных полос
        if (N < 1 || N >= Math.pow(10, 5)) {
            System.out.println("Некорректное количество наклеенных полос");
            return;
        }

        long L = scanner.nextLong(); // ширина стены
        if (L < 1 || L > Math.pow(10, 18)) {
            System.out.println("Некорректное значение ширины стены");
            return;
        }

        long W = scanner.nextLong(); // ширина рулона обоев
        if (W < 1 || W >= L) {
            System.out.println("Некорректное значение ширины рулона обоев");
            return;
        }

        // Создаем массив стены и инициализируем его нулями
        int[] wall = new int[(int) L];

        // Заполняем массив значениями "1" для уже наклеенных полос
        for (int i = 0; i < N; i++) {
            int startX = scanner.nextInt();
            int endX = startX + (int) W;
            Arrays.fill(wall, startX, endX, 1);
        }

        // Считаем количество полос для покрытия оставшихся участков
        int count = 0;
        for (int i = 0; i < L; i++) {
            if (wall[i] == 0) {
                count++;
                i += (int) (W - 1); // пропускаем уже покрытые участки
            }
        }

        System.out.println(count);

        // Закрытие сканнера
        scanner.close();
    }
}
