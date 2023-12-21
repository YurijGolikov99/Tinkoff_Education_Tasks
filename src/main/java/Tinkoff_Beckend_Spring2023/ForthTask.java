package org.example.Tinkoff_Beckend_Spring2023;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ForthTask {
    static int n;
    static int[] a, ans;
    static List<Integer>[] e;
    static void dfs(int u) {
        for (int v : e[u]) {
            ans[v] += ans[u];
            dfs(v);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n + 1];
        ans = new int[n + 1];
        e = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            e[i] = new ArrayList<>();
        }
        for (int i = 2; i <= n; i++) {
            int x = sc.nextInt();
            int len = sc.nextInt();
            if (len <= a[i]) {
                e[x].add(i);
                ans[i] = 1;
            }
        }
        dfs(1);
        for (int i = 1; i <= n; i++) {
            System.out.println(ans[i] - 1);
        }
    }
}
