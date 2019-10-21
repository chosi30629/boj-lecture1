package review.bruteforce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/14501
public class PS14501 {
    static int[] t;
    static int[] p;
    static int n;
    static int ans;

    static void go(int day, int sum) {
        if (day == n + 1) {     // 퇴사날에 정답
            if (ans < sum) {
                ans = sum;
            }
            return;
        }
        if (day > n + 1) {      // 불가능한 경우 : 퇴사일 넘어감
            return;
        }
        go(day + 1, sum);                         // 상담을 하지 않는다.
        go(day + t[day], sum + p[day]);      // 한다. 순서바뀌어도 정답
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        t = new int[n+1];
        p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            t[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
        }
        go(1, 0);
        System.out.println(ans);
    }

}
