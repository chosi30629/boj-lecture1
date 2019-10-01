package math;

import java.util.Scanner;

/*
    문제
        양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.

    입력
        첫째 줄에 테스트 케이스의 개수 t (1 ≤ t ≤ 100)이 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있다. 각 테스트 케이스는 수의 개수 n (1 < n ≤ 100)가 주어지고, 다음에는 n개의 수가 주어진다. 입력으로 주어지는 수는 1000000을 넘지 않는다.

    출력
        각 테스트 케이스마다 가능한 모든 쌍의 GCD의 합을 출력한다.

    예제 입력 1
    3
    4 10 20 30 40
    3 7 5 12
    3 125 15 25

    예제 출력 1
    70
    3
    35
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainCnt = scanner.nextInt();
        while (mainCnt-- > 0) {
            int numCnt = scanner.nextInt();
            int[] numArr = new int[numCnt];
            for (int i = 0; i < numCnt; i++) {
                numArr[i] = scanner.nextInt();
            }

            long sum = 0;
            for (int i = 0; i < numArr.length - 1; i++) {
                for (int j = i + 1; j < numArr.length; j++) {
                    sum += gcd(numArr[i], numArr[j]);
                }
            }
            System.out.println(sum);
        }
    }
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
