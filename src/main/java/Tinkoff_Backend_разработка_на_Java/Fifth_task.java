package org.example.Backend_разработка_на_Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
задание 5
Виктор занимается проектированием локальной сети в новом офисе.
Новый офис представляет из себя координатную плоскость. В офисе планируется разместить  n  компьютеров сотрудников и
m  серверов. Для каждого сервера и компьютера сотрудника известна координата, в которой они будут расположены.
В локальной сети могут быть подключения двух видов: от сервера к другому серверу или от сервера к компьютеру сотрудника. Подключений другого вида быть не может. Подключение в сети может быть только односторонним, поэтому если сервер a подключен к серверу  b  (то есть сервер  a  может отправлять данные серверу  b ), то сервер  b  не может быть подключен к серверу  a  (то есть сервер  b  не может отправлять данные серверу a ). Длина провода, необходимого для подключения, равна квадрату декартового расстояния между точками, в которых находятся компьютер или сервер, которые соединяются подключением.
Виктор должен спроектировать такую сеть, чтобы любой сервер мог отправить информацию на компьютер любого сотрудника напрямую или через какие-то промежуточные сервера. При этом Витя хочет сэкономить, поэтому он хочет найти такой способ подключения серверов и компьютеров, чтобы в нем было минимальное количество подключений, а при равенстве количества, суммарная длина проводов в этих подключениях также была минимальной. Помогите Виктору спланировать сеть.
Формат входных данных
В первой строке входных данных через пробел даны два целых числа  n  и  m  — количество компьютеров сотрудников и серверов  (1≤n≤10^4; 1≤m≤5⋅10^3).
В следующих  n  строках даны координаты расположения компьютеров сотрудников. Компьютер с номером  i  планируется расположить в точек  xi  и  yi (−10^8≤xi,yi≤10^8).
Аналогично, в следующих  m  строках дано расположение серверов в офисе.
Формат выходных данных
В первой строке строке выведите два целых числа  k  и  l  — количество подключений и сумму квадратов длин всех подключений.
В следующих  k  строках выведите описание схему сети. В строке с номером  i  должно быть описание  i -го подключения в формате « fi  ->  ti» (без кавычек), где
fi  и  ti  — обозначение устройства: ‘s’ и номер сервера (через пробел), если это сервер, и ‘c’ и номер компьютера, если это компьютер сотрудника.
Примеры данных:
1)Пример
мы вводим
2 3
4 8
1 4
2 6
4 5
4 2
выводим:
4 27
s 2 - > s 1
s 3 - > s 2
s 1 - > c 1
s 1 - > c 2
*/

public class Fifth_task {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(weight, other.weight);
        }
    }

    static int[] parent;

    static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            parent[parentA] = parentB;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Point[] computers = new Point[n];
        Point[] servers = new Point[m];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            computers[i] = new Point(x, y);
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            servers[i] = new Point(x, y);
        }

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int distance = (computers[i].x - servers[j].x) * (computers[i].x - servers[j].x) +
                        (computers[i].y - servers[j].y) * (computers[i].y - servers[j].y);
                edges.add(new Edge(i, n + j, distance));
            }
        }

        Collections.sort(edges);

        parent = new int[n + m];
        for (int i = 0; i < n + m; i++) {
            parent[i] = i;
        }

        int connections = 0;
        long totalLength = 0;

        List<String> networkConnections = new ArrayList<>();

        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                connections++;
                totalLength += edge.weight;

                if (edge.from < n && edge.to >= n) {
                    networkConnections.add("c " + (edge.from + 1) + " -> s " + (edge.to - n + 1));
                } else if (edge.from >= n && edge.to < n) {
                    networkConnections.add("s " + (edge.from - n + 1) + " -> c " + (edge.to + 1));
                } else {
                    networkConnections.add("s " + (edge.from - n + 1) + " -> s " + (edge.to - n + 1));
                }
            }

            if (connections == n + m - 1) {
                break;
            }
        }

        System.out.println(connections + " " + totalLength);
        for (String connection : networkConnections) {
            System.out.println(connection);
        }
    }
}