package backenddevelopmentonJava2023;

import java.util.Scanner;

/*
1 задание
В одной компании решили создать свою модель машинного обучения. Обучение модели происходит на большом количестве наборов данных. Чтобы ускорить процесс было решено одновременно обучать модель на s серверах разной мощности с номерами от 1 до  s . Мощность сервера равна его номеру и определяет то, сколько наборов данных он обрабатывает за один раз. Например, сервер с номером 1 имеет мощность 1 и обрабатывает 1 набор данных за единицу времени, а сервер с номером s  обрабатывает s  наборов данных. В силу устройства, ни один сервер не может за один раз обработать наборов меньше, чем его мощность. Сегодня сотрудникам необходимо обучить модель на n наборах данных. Было решено распределять данные между серверами циклически: начать с сервера с номером s, затем дать данные серверам с номерами  s-1, s-2, ..., 2, 1, s, s-1  и так далее. Раздача данных серверам останавливается в тот момент, когда данных становится меньше, чем мощность текущего сервера. Оставшиеся после такого распределения данные приходится обрабатывать вручную. Помогите сотрудникам компании и скажите, сколько наборов данных придется обработать вручную.
Формат входных данных
В первой строке содержатся число s(1≤s≤64)  — количество серверов. Во второй строке содержится число
n(1≤n≤10^5) — количество наборов данных, на которых необходимо обучить модель.
Формат выходных данных
В единственной строке выходных данных выведите одно число — ответ на вопрос задачи.
Замечание
Порядок распределения наборов данных в первом примере из тестов:
* Cервер 4: обработка четырех наборов данных, 14 − 4 = 10;
* Cервер 3: обработка трех наборов данных, 10 − 3 = 7;
* Cервер 2: обработка двух наборов данных, 7 − 2 = 5;
* Cервер 1: обработка одного наборов данных, 5 − 1 = 4;
* Cервер 4: обработка четырех наборов данных, 4 − 4 = 0.
Примеры данных:
1)Пример
мы вводим в первой строке - 4
во второй строке вводим - 14
выводим - 0
2)Пример:
мы вводим в первой строке - 3
во второй строке вводим - 8
выводим - 2
3)Пример
мы вводим в первой строке - 13
во второй строке вводим - 100
выводим - 9
 */

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt(); // Количество серверов
        int n = scanner.nextInt(); // Количество наборов данных

        int remainingData = n; // Сколько данных осталось обработать вручную
        int currentServer = s; // Текущий сервер

        while (remainingData >= currentServer) {
            remainingData -= currentServer;
            currentServer = (currentServer == 1) ? s : currentServer - 1;
        }

        System.out.println(remainingData);
    }
}