package dp.dp3;

import java.util.Scanner;

/*
    문제
        수열 A가 주어졌을 때, 그 수열의 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.
        예를 들어, 수열 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 인 경우에 합이 가장 큰 증가 부분 수열은 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 이고, 합은 113이다.

    입력
        첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
        둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

    출력
        첫째 줄에 수열 A의 합이 가장 큰 증가 부분 수열의 합을 출력한다.

    예제 입력 1
    10
    1 100 2 50 60 3 5 6 7 8
    예제 출력 1
    113
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = a[i];
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && d[i] < d[j] + a[i]) {
                    d[i] = d[j] + a[i];
                }
            }
        }
        int ans = d[0];
        for (int i = 0; i < n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }
        System.out.println(ans);
    }

}
