package beckendspring2023;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = 0;
        boolean positive = true;

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            String sign = sc.next();
            temp += d;
            if (temp < 0) {
                positive = false;
                break;
            }
            if (sign.equals("0+")) {
                positive = true;
            }
        }

        if (positive) {
            System.out.println(temp);
        } else {
            System.out.println(0);
        }
    }
}
