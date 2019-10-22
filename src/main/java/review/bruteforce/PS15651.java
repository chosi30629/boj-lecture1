package review.bruteforce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/15651
public class PS15651 {
    static int[] a = new int[10];
    static StringBuffer sb = new StringBuffer();
    static StringBuffer go(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return sb;
        }
        for (int i = 1; i <= n; i++) {
            a[index] = i;
            go(index + 1, n, m);
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(go(0, n, m));
    }

}
