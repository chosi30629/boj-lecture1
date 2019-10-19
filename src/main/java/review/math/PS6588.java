package review.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/6588
public class PS6588 {
    static int MAX = 1000000;
    static boolean[] c = new boolean[MAX + 1];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 소수가 아닌 것들은 지운다. 지운다 == true, 지우지 않는다(소수) == false
        c[0] = c[1] = true;

        // 에라토스테네스의 체(가장 최적의 소수 구하기)
        for (int i = 2; i <= MAX; i++) {
            if (!c[i]) {
                for (int j = i + i; j <= MAX; j += i) { // 배수 지우기, 만약 2의 배수들은 약수 2를 가지고 있기 때문에 소수가 아님
                    c[j] = true;
                }
            }
        }

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 2; i < n; i++) {
                if (!c[i] && !c[n - i]) {   // 골드바흐의 추측
                    System.out.println(n + " = " + i + " + " + (n - i));
                    break;
                }
            }
        }
    }

}
