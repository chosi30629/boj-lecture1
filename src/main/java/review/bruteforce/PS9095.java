package review.bruteforce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9095
// 브루트포스를 이용하여 풀기(DP 이용할 수 있음)
public class PS9095 {

    static int go(int sum, int goal) {
        if (sum > goal) {   // 불가능한 경우(함수를 호출해도 더이상 답을 찾을 수 없는 경우)
            return 0;
        }
        if (sum == goal) {  // 정답을 찾은 경우(정답 하나를 찾음)
            return 1;
        }
        int now = 0;
        for (int i = 1; i <= 3; i++) {
            now += go(sum + i, goal);
        }
        return now;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(go(0, n));
        }
    }

}
