package math;

import java.util.Scanner;

/*
    문제
        두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

    입력
        첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

    출력
        첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

    예제 입력 1
    24 18

    예제 출력 1
    6
    72
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        String[] numArr = nums.split(" ");
        int a = Integer.parseInt(numArr[0]);
        int b = Integer.parseInt(numArr[1]);
        if (a > 10000 || b > 10000) {
            return;
        }

        // 모든 정수는 약수 1을 갖기 때문에 최대공약수를 1로 가정하고 시작한다.
        int gcd = 1;
        // 약수 N이랑 같거나 작기 때문에 공약수는 둘 중 작은 수로 조건주면 된다.
        for (int i = 2; i <= Math.min(a, b); i++) {
            // a 가 0 으로 나누어 떨어지면서 b 도 0 으로 나누어 떨어지는 수를 구한다.(약수)
            if ((a % i == 0) && (b % i == 0)) {
                // 최대공약수를 구하기 때문에 반복문이 끝날때까지 gcd 에 i 를 대입한다.
                gcd = i;
            }
        }
        // 시간 복잡도 O(N)
        System.out.println(gcd);
        System.out.println((a * b) / gcd);


    }

    // 위의 방법보다 더 빠른 시간 복잡도 logN
    // 유클리드 호제법 1
    public static int gcd1(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd1(b, a % b);
        }
    }

    // 유클리드 호제법 2 (재귀 미사용)
    public static int gcd2(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
