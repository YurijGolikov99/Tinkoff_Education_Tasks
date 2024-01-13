package backenddevelopmentonjavaspring2024;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Дракоша Катя хочет провести большую вечеринку. Она уже определилась с тем, сколько и каких угощений она приготовит для гостей, однако не определилась, кого звать.
Про каждого друга-дракона Катя знает две характеристики a_i и b_i интересность и прожорливость.
Некоторые драконы могут дружить друг с другом. Также считается, что драконы і и j знакомы, если они дружат или дружат через одного или нескольких общих друзей. Более формально, дракон і знаком с драконом j, если существует последовательность драконов i = C1_, С_2, ..., C_k = j такая, что дракон C_t-1 дружит с драконом С_t.
Катя не может позвать дракона і, если не позовет дракона j, который знаком с драконом і. Если она так сделает, то дракон j узнает о вечеринке и обидится на Катю.
Катя хочет позвать такое множество друзей, чтобы суммарная прожорливость всех гостей не превышала g, а интересность приглашенных драконов была максимальной. Помогите Кате завершить приготовления к вечеринке и определиться со списком гостей.

Формат входных данных
Первая строка входных данных содержит три целых числа n,m и gw — число друзей Кати, число пар драконов, которые дружат друг с другом, и максимальная суммарная прожорливость друзей, на которую хватит угощений, заготовленных Катей (1 <= n <= 10^3, 0 <= m <= 10^5, 1 <= g <= 10^3).
Вторая строка входных данных содержит n целых чисел a_1, a_2, ..., a_n (1 <= a_i <= 10^6) - интересность драконов-друзей Кати.
Третья строка содержит n целых чисел b_1, b_2, ..., b_n (1 <= b_i <= 10^3) - прожорливость драконов-друзей Кати.
В следующих m строках дано описание пар друзей-драконов, которые дружат друг с другом напрямую. Каждая пара друзей задается номерами драконов u_i и v_i (1 <= U_i, V_i <= n, u_i не равно V_i). При этом все пары номеров друзей (Ui, Vi) различны, а отношение дракон u_i; дружит с драконом v_i является симметричным.

Формат выходных данных
В единственной строке выходного файла выведите наибольшую возможную суммарную интересность драконов, которых Екатерина может позвать на вечеринку, так чтобы соблюсти все
условия.

Примеры данных
Пример 1
Ввод
3 1 3
2 2 3
3 1 2
2 3
Вывод
5

Пример 2
Ввод
4 2 5
1 2 1 2
4 1 2 3
2 3
3 4
Вывод
1


Пример 3
Ввод
6 3 6
1 2 3 4 4 5
1 1 2 2 2 3
1 2
3 4
5 6
Вывод
10
 */

public class ForthTaskPasrtyForEverybody {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int g = scanner.nextInt();
        Dragon[] dragons = new Dragon[n];
        for (int i = 0; i < n; i++) {
            int interest = scanner.nextInt();
            dragons[i] = new Dragon(i, interest, 0);
        }

        for (int i = 0; i < n; i++) {
            dragons[i].voracity = scanner.nextInt();
        }

        List<Integer>[] friends = new List[n];
        for (int i = 0; i < n; i++) {
            friends[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            friends[u].add(v);
            friends[v].add(u);
        }
        boolean[] invited = new boolean[n];
        PriorityQueue<Dragon> priorityQueue = new PriorityQueue<>();
        long totalVoracity = 0;
        long maxInterest = 0;
        for (int i = 0; i < n; i++) {
            if (!invited[i]) {
                long currentVoracity = 0;
                long currentInterest = 0;
                priorityQueue.add(dragons[i]);
                invited[i] = true;
                while (!priorityQueue.isEmpty()) {
                    Dragon currentDragon = priorityQueue.poll();
                    currentVoracity += currentDragon.voracity;
                    currentInterest += currentDragon.interest;
                    for (int friend : friends[currentDragon.index]) {
                        if (!invited[friend]) {
                            priorityQueue.add(dragons[friend]);
                            invited[friend] = true;
                        }
                    }
                }
                if (currentVoracity <= g && currentInterest > maxInterest) {
                    maxInterest = currentInterest;
                    totalVoracity = currentVoracity;
                }
            }
        }
        System.out.println(maxInterest);
    }
}

class Dragon implements Comparable<Dragon> {
    int index;
    int interest;
    int voracity;
    public Dragon(int index, int interest, int voracity) {
        this.index = index;
        this.interest = interest;
        this.voracity = voracity;
    }
    @Override
    public int compareTo(Dragon other) {
        return Integer.compare(other.interest, this.interest);
    }
}
