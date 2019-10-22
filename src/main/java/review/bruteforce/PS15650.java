package review.bruteforce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/15650
public class PS15650 {
    static int[] a = new int[10];
    static boolean[] c = new boolean[10];

    static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i]);
                if (i != m - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = start; i <= n; i++) {
            if (c[i]) {
                continue;
            }
            c[i] = true;
            a[index] = i;
            go(index + 1, i + 1, n, m);
            c[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        go(0, 1, n, m);
    }

}
