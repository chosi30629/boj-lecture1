package review.bruteforce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1182
public class PS1182 {

    static int solve(int[] a, int m, int i, int sum) {
        if (i == a.length) {    // 더이상 찾을 것이 없고
            if (sum == m) {     // 정답을 찾았으면
                return 1;       // + 1
            } else {
                return 0;
            }
        }
        return solve(a, m, i+1, sum + a[i]) + solve(a, m, i+1, sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int ans = solve(a, m, 0, 0);
        if (m == 0) {   // 공집합을 제외하기, 합이 0인...
            ans -= 1;
        }
        System.out.println(ans);
    }

}
