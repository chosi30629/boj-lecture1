package dp;

import java.util.Scanner;

/*
    문제
        피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
        이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n>=2)가 된다.
        n=17일때 까지 피보나치 수를 써보면 다음과 같다.
        0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
        n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

    입력
        첫째 줄에 n이 주어진다. n은 45보다 작거나 같은 자연수이다.

    출력
        첫째 줄에 n번째 피보나치 수를 출력한다.

    예제 입력 1
    10
    예제 출력 1
    55
 */
public class Fibonacci {

    // 이러면 시간초과 시간복잡도 n²
    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int[] memo = new int[100];
    static int topDown(int n) {
        if (n <= 1) {
            return n;
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
            memo[n] = topDown(n - 1) + topDown(n - 2);
            return memo[n];
        }
    }

    static int d[] = new int[100];
    static int bottomUp(int n) {
        d[0] = 0;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        return d[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacci(n));
        System.out.println(topDown(n));
        System.out.println(bottomUp(n));
    }

}
