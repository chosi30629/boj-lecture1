package review.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15665
public class PS15665 {
    static int[] a = new int[10];
    static int[] num = new int[10];
    static StringBuffer sb = new StringBuffer();

    static StringBuffer go(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return sb;
        }
        for (int i = 0; i < n; i++) {
            a[index] = num[i];
            go(index + 1, n, m);
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = scanner.nextInt();
        }
        Arrays.sort(temp);
        int k = 0;
        int x = temp[0];
        for (int i = 1; i < n; i++) {
            if (x != temp[i]) {
                num[k] = x;
                ++k;
                x = temp[i];
            }
        }
        num[k] = x;
        n = ++k;
        System.out.println(go(0, n, m));
    }

}
