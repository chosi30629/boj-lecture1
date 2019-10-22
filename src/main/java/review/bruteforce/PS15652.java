package review.bruteforce;

import java.util.Scanner;

public class PS15652 {
    static int[] a = new int[10];
    static StringBuffer sb = new StringBuffer();

    static StringBuffer go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return sb;
        }
        for (int i = start; i <= n; i++) {
            a[index] = i;
            go(index + 1, i, n, m);
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(go(0, 1, n, m));
    }

}
