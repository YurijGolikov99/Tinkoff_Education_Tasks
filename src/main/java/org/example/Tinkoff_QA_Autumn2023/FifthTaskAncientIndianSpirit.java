package org.example.Tinkoff_QA_Autumn2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FifthTaskAncientIndianSpirit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();
        int maxWeight = 0;

        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt();
            int u = scanner.nextInt();
            int w = scanner.nextInt();
            edges.add(new Edge(v, u, w));
            maxWeight = Math.max(maxWeight, w);
        }

        int left = 0;
        int right = maxWeight;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canDestroyEdges(edges, n, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static class Edge {
        int v, u, w;

        Edge(int v, int u, int w) {
            this.v = v;
            this.u = u;
            this.w = w;
        }
    }

    static boolean canDestroyEdges(List<Edge> edges, int n, int x) {
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (Edge edge : edges) {
            if (edge.w <= x) {
                int parentV = findParent(parent, edge.v);
                int parentU = findParent(parent, edge.u);
                if (parentV != parentU) {
                    parent[parentU] = parentV;
                    n--;
                }
            }
        }

        return n == 1;
    }

    static int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }
}


/*
Древний индейский дух Чогэн пробудился и отправился карать бледнолицых. Ничто не способно его остановить, так что ковбой Джо выступает в роли наблюдателя в этой задаче.

На Диком западе n городов и m двусторонних дорог между ними. Штатом называется такое множества городов, для которого верно:
    Из любого города этого множества можно добраться по дорогам до любого другого города из этого множества;
    Из любого города этого множества нельзя добраться по дорогам до любого города не из этого множества.

Из любого города можно добраться по дорогам до самого себя, используя 0 дорог.

Дух Чогэн выбирает целое число x и уничтожает все дороги длиной не более x. Несложно заметить, что Дикий запад однозначно разбивается на штаты. Дух Чогэн хочет уничтожить как можно больше дорог, но количество штатов должно остаться неизменным. Помогите духу выбрать максимальное доступное число x.

Формат входных данных
В первой строке даны целые числа n,m (2≤n≤2⋅10^5, 1≤m≤2⋅10^5) — количество городов и
дорог.
В следующих m строках даны целые числа v,u,w (1≤v,u≤n,1≤w≤10^9) — номера городов,
соединенных дорогой и её длина.
Между какими-то городами могут быть проведены несколько дорог, также могут быть дороги из города в себя же.
Гарантируется, что изначальное количество штатов строго меньше n.

Формат выходных данных
В единственной строке выведите целое число x.

Примеры данных
Пример 1
ввод
2 2
1 2 6
2 1 9
вывод
8

Пример 2
ввод
5 6
1 2 8
2 3 6
2 3 2
3 1 4
5 4 1
4 5 8
вывод
5
 */
