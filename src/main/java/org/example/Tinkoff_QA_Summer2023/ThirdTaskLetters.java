package org.example.Tinkoff_QA_Summer2023;

import java.util.*;

public class ThirdTaskLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int[] cnt = new int[4];
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
            while (cnt[s.charAt(left) - 'a'] > 1) {
                cnt[s.charAt(left) - 'a']--;
                left++;
            }
            if (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0 && cnt[3] > 0) {
                int len = i - left + 1;
                if (len < minLen) {
                    minLen = len;
                    right = i;
                }
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minLen);
        }
    }
}
// Third_task-zalupa with letters