package dp.dp3;

import java.util.Scanner;

/*
    문제
        수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.
        예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.
        수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

    입력
        첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)

    출력
        첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.

    예제 입력 1
    10
    1 5 2 1 4 3 4 5 2 1
    예제 출력 1
    7

    힌트
    예제의 경우 {1 5 2 1 4 3 4 5 2 1}이 가장 긴 바이토닉 부분 수열이다.
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] d = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }

            }
        }
        for (int i = n - 1; i >= 0; i--) {
            v[i] = 1;
            for (int j = i + 1; j < n ; j++) {
                if (a[i] > a[j] && v[j] + 1 > v[i]) {
                    v[i] =  v[j] + 1;
                }

            }
        }

        int ans = d[0] + v[0] - 1;
        for (int i = 0; i < n; i++) {
            System.out.println(d[i] + " " + v[i] + " " + (d[i] + v[i] - 1));
            if (ans < d[i] + v[i] - 1) {
                ans = d[i] + v[i] - 1;
            }
        }
        System.out.println(ans);
    }

}
