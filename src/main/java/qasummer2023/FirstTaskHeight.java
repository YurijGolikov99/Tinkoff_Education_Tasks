package qasummer2023;

import java.util.*;

public class FirstTaskHeight {
    public void firstTaskHeight() {
        Scanner sc = new Scanner(System.in);
        int h1 = sc.nextInt();
        int h2 = sc.nextInt();
        int h3 = sc.nextInt();
        int h4 = sc.nextInt();

        if (h1 < 0 || h2 < 0 || h3 < 0 || h4 < 0 ||
                h1 > 300 || h2 > 300 || h3 > 300 || h4 > 300) {
            System.out.println("NO");
        } else if (h1 <= h2 && h2 <= h3 && h3 <= h4) {
            System.out.println("YES");
        } else if (h1 >= h2 && h2 >= h3 && h3 >= h4) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
