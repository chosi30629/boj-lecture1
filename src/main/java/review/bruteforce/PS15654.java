package review.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15654
public class PS15654 {
    static int[] a;
    static int[] s;
    static boolean[] c;
    static StringBuffer sb = new StringBuffer();

    static StringBuffer go(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(s[i] + " ");
            }
            sb.append("\n");
            return sb;
        }

        for (int i = 0; i < n; i++) {
            if (c[i]) {
                continue;
            }
            c[i] = true;
            s[index] = a[i];
            go(index + 1, n, m);
            c[i] = false;
        }

        return sb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        a = new int[n];
        s = new int[n];
        c = new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        System.out.println(go(0, n, m));
    }

}
