package qasummer2023;

import java.util.*;

public class SecondTaskTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int num_reviews = n * k;
        int time = (num_reviews + m - 1) / m;
        if (n < 0 || m < 0 || k < 0 ||
                n > Math.pow(10, 4) || m > Math.pow(10, 4) || k > Math.pow(10, 4) ) {
            System.out.println("incorrect value");
        } else {
            System.out.println(time);
        }
    }
}
