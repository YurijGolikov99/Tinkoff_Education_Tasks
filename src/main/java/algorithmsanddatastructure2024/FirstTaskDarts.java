package algorithmsanddatastructure2024;

import java.util.Scanner;

/*
Саша и Дима собирают робота, который смог бы работать без помощи человека. Для этого им необходимо обучить ИИ в голове робота. Ребята решили начать с простого — научить робота определять результат одного хода в игре дартс.
Напомним правила в этой игре. За один подход игрок делает 3 броска дротика в сторону мишени.
Для простоты будем считать, что мишень имеет форму круга с радиусом 1 и центром в точке (0, 0).
За каждый из трех бросков игроку начисляются очки.
• Если дротик попадает в точку на расстоянии не больше 0.1 от центра, к счету игрока добавляется три очка.
• Если дротик попадает в точку на расстоянии больше 0.1, но не больше 0.8 от центра, к счету игрока добавляется два очка.
• Если дротик попадает в точку на расстоянии больше 0.8, но не больше 1 от центра, к счету игрока добавляется одно очко.
• Если дротик не попадает в мишень, счет игрока не меняется.
Вам даны координаты попадания дротиков в результате трех бросков. Найдите суммарное число очков, которое было начислено в результате этого подхода.

Формат входных данных
В трех строках входных данных даны пары вещественных чисел Хі, Уі — координаты попаданий дротиков (-2 ≤ X1,Y1,X2,Y2,X3,Y3 ≤ 2).

Формат выходных данных
В качестве ответа выведите одно число — сумму очков, начисленную в результате трех бросков.

Система оценки
Баллы за каждую подзадачу начисляются только в случае, если все тесты этой подзадачи и необходимых подзадач успешно пройдены.

Примеры данных
Пример 1
Ввод
0.0 0.0
0.1 0.0
0.5 0.5
Вывод
8

Пример 2
Ввод
0.5 0.5
2.0 1.0
0.05 0.05
Вывод
5

Пример 3
Ввод
0.0 0.1
0.0 0.8
0.0 1.0
Вывод
6

 */
public class FirstTaskDarts {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода данных
        Scanner scanner = new Scanner(System.in);

        // Читаем координаты попадания дротиков
        double x1 = readCoordinate(scanner);
        double y1 = readCoordinate(scanner);
        double x2 = readCoordinate(scanner);
        double y2 = readCoordinate(scanner);
        double x3 = readCoordinate(scanner);
        double y3 = readCoordinate(scanner);

        // Закрываем Scanner
        scanner.close();

        // Вычисляем расстояние от центра до каждой точки
        double distance1 = Math.sqrt(x1 * x1 + y1 * y1);
        double distance2 = Math.sqrt(x2 * x2 + y2 * y2);
        double distance3 = Math.sqrt(x3 * x3 + y3 * y3);

        // Начисляем очки в соответствии с правилами
        int score1 = calculateScore(distance1);
        int score2 = calculateScore(distance2);
        int score3 = calculateScore(distance3);

        // Проверяем, все ли тесты для подзадачи успешно пройдены
        boolean allTestsPassed = (score1 >= 0) && (score2 >= 0) && (score3 >= 0);

        if (allTestsPassed) {
            // Суммируем очки
            int totalScore = score1 + score2 + score3;
            // Выводим результат
            System.out.println(totalScore);
        } else {
            // Если хотя бы один тест не пройден, выводим сообщение об ошибке
            System.out.println("Ошибка: Не все тесты подзадачи пройдены.");
        }
    }

    // Метод для считывания координат и проверки на положительность
    private static double readCoordinate(Scanner scanner) {
        double coordinate = Double.parseDouble(scanner.next());
        if (coordinate < 0) {
            System.out.println("Ошибка: Координаты должны быть неотрицательными.");
            System.exit(1); // Завершаем программу в случае ошибки
        }
        return coordinate;
    }

    // Метод для вычисления очков в зависимости от расстояния до центра
    private static int calculateScore(double distance) {
        if (distance <= 0.1) {
            return 3;
        } else if (distance <= 0.8) {
            return 2;
        } else if (distance <= 1.0) {
            return 1;
        } else {
            return 0;
        }
    }
}
