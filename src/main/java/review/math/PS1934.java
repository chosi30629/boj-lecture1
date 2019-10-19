package review.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1934
public class PS1934 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int gcd = gcd(a, b);                // 최대공약수
            System.out.println((a * b) / gcd);  // 최소공배수
        }
    }

    static int gcd(int a, int b) {              // 유클리드 호제법은 이용한 최대공약수 구하기
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
