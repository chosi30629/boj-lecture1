package review.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15663
public class PS15663 {
    static int[] a = new int[10];
    static int[] num = new int[10];
    static int[] cnt = new int[10];
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
            if (cnt[i] > 0) {
                cnt[i] -= 1;
                a[index] = num[i];
                go(index + 1, n, m);
                cnt[i] += 1;
            }
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
        int k = 0;          // 배열에 사용할 인덱스
        int x = temp[0];    // 중복확인을 위한 첫번째 인덱스값
        int c = 1;          // 갯수
        for (int i = 1; i < n; i++) {
            if (x == temp[i]) {
                c += 1;
            } else {
                num[k] = x;
                cnt[k] = c;
                k += 1;
                x = temp[i];
                c = 1;
            }
        }
        num[k] = x;
        cnt[k] = c;
        n = ++k;
        System.out.println(go(0, n, m));
    }

}
