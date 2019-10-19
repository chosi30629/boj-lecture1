package review.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2609
public class PS2609 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int gcd = gcd(a, b);                // 최대공약수
        System.out.println(gcd);
        System.out.println((a * b) / gcd);  // 최소공배수
    }

    // 재귀함수를 사용한 유클리드 호제법
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
