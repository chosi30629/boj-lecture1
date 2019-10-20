package review.bruteforce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10971
/*
0
10
15
20
5
0
9
10
6
13
0
12
8
8
9
0
 */
public class PS10971 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            d[i] = i;
        }

        int ans = Integer.MAX_VALUE;
        do {
            if (d[0] != 0) {    // N * N! 을 N! 로... 시작점을 0로 고정
                break;
            }
            boolean ok = true;
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (a[d[i]][d[i+1]] == 0) {
                    ok = false;
                } else {
                    sum += a[d[i]][d[i+1]];
                }
            }
            if (ok && a[d[n-1]][d[0]] != 0) {   // n-1 마지막 도시에서 d[0] 원래도시로 돌아오는게 0인지 판별
                sum += a[d[n-1]][d[0]];
                if (ans > sum) {
                    ans = sum;
                }
            }
        } while (next_permutation(d));
        System.out.println(ans);
    }

    private static boolean next_permutation(int[] a) {
        int length = a.length - 1;
        int i = length;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }

        int j = length;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = length;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }

}
