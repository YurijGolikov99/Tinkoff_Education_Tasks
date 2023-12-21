package Tinkoff_Beckend_Spring2023;

import java.util.Arrays;
import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] cnt = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                cnt[c - '0']++;
            }
        }
        int[] expectedCnt = new int[10];
        Arrays.fill(expectedCnt, s.length() / 10);
        for (int i = 0; i < s.length() % 10; i++) {
            expectedCnt[i]++;
        }
        for (int i = 0; i < 10; i++) {
            if (cnt[i] > expectedCnt[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
