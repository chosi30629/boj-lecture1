package review.bruteforce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/15649
public class PS15649 {
    static int n;
    static int m;
    static int[] a = new int[10];
    static boolean[] c = new boolean[10];

    static void go(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i]);
                if (i != m - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (c[i]) {
                continue;
            }
            c[i] = true;
            a[index] = i;
            go(index + 1);
            c[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        go(0);
    }

}
