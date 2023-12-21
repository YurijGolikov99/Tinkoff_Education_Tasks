package Tinkoff_Beckend_Spring2023;
import java.util.*;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        int[] cnt = new int[k + 1];
        for (int i = 1; i <= n; i++) {
            cnt[p[i]]++;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (p[a] == p[b]) {
                res++;
            }
        }
        int t = 0;
        for (int i = 1; i <= k; i++) {
            if (cnt[i] >= 2) {
                t = Math.max(t, cnt[i] - res);
            }
        }
        System.out.println(m - res + t / 2);
    }
}
