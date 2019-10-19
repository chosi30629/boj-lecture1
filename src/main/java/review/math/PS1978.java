package review.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1929
public class PS1978 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (prime(a[i])) {
                sum += 1;
            }
        }
        System.out.println(sum);
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
