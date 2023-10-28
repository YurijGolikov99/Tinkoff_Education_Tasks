package org.example.Tinkoff_QA_Autumn2023;

import java.util.Scanner;
public class FirstTask {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int s = scanner.nextInt();
    if (n < 1 || n > 2 * Math.pow(10, 5) || s < 1 || s > Math.pow(10, 9)) {
        System.out.println("Входные данные находятся вне допустимого диапазона.");
        return;
    }

        int max_price = 0;

        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            if (price <= s && price > max_price) {
                max_price = price;
            }
        }

        if (max_price == 0) {
            System.out.println(0);
        } else {
            System.out.println(max_price);
        }
    }
}
/*
Однажды ковбой Джо решил обзавестись револьвером и пришёл в оружейный магазин.
У ковбоя s долларов, а на выбор представлены n револьверов с ценами a1,a2,…,an.
Помогите ковбою Джо выбрать самый дорогой револьвер, который он может себе позволить
или сообщите, что такого не существует.

Формат входных данных
В первой строке даны целые числа n, s (1≤n≤2⋅10^5, 1≤s≤10^9) — количество револьверов
в магазине и количество долларов у ковбоя Джо.

Во второй строке даны n целых чисел a1,a2,…,an, (1≤ai≤10^9) — цены револьверов в магазине.

Формат выходных данных
Выведите единственное целое число — цену самого дорого револьвера, который ковбой Джо сможет
себе позволить, если такого револьвера нет, выведите 0.
Примеры данных
Пример 1
ввод
5 13
3 10 300 15 3
вывод
10

Пример 2
ввод
3 4
5 12 10
вывод
0
 */