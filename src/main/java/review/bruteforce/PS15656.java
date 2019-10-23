package review.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15656
public class PS15656 {
    static int[] a;
    static int[] s;
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
            s[index] = a[i];
            go(index + 1, n, m);
        }

        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.valueOf(nm[0]);
        int m = Integer.valueOf(nm[1]);
        a = new int[n];
        s = new int[n];

        String[] num = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.valueOf(num[i]);
        }
        Arrays.sort(a);

        System.out.println(go(0, n, m));
    }

}
