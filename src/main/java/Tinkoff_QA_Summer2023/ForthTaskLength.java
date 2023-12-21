package Tinkoff_QA_Summer2023;

import java.util.*;

public class ForthTaskLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Map<Integer, Integer> freq = new HashMap<>();
        int boringLength = 0;
        for (int i = 0; i < n; i++) {
            freq.put(a[i], freq.getOrDefault(a[i], 0) + 1);
            boolean isBoring = true;
            for (int key : freq.keySet()) {
                int count = freq.get(key);
                if (count == 1) {
                    continue;
                }
                if (count - 1 > n - i - 1 || count < (i + 1) / count) {
                    isBoring = false;
                    break;
                }
            }
            if (isBoring) {
                boringLength = i + 1;
            }
        }
        System.out.println(boringLength);
    }
}
