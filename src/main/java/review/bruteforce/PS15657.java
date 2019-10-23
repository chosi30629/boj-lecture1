package review.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15657
public class PS15657 {
    static int[] a;
    static int[] s;
    static StringBuffer sb = new StringBuffer();

    static StringBuffer go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(s[i] + " ");
            }
            sb.append("\n");
            return sb;
        }
        for (int i = start; i < n; i++) {
            s[index] = a[i];
            go(index + 1, i, n, m);
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        a = new int[n];
        s = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        System.out.println(go(0, 0, n, m));
    }

}
