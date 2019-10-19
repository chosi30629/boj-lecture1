package review.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9613
public class PS9613 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            long sum = 0;   // long 타입으로 해야함...
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum += gcd(a[i], a[j]);
                }
            }
            System.out.println(sum);
        }
    }

    static int gcd(int a, int b) {  // 유클리드 호제법을 이용한 최대공약수 구하기
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
