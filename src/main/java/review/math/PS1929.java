package review.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1929
public class PS1929 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = n; i <= m; i++) {
            if (prime(i)) {
                System.out.println(i);
            }
        }
    }

    static boolean prime(int n) {   // 에라토스테네스의 체를 사용하지 않고 제일 빠르게 소수 구하는 방법
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
