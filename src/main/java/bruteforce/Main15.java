package bruteforce;

import java.util.Scanner;

/*
    문제
        N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.

    입력
        첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.

    출력
        첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.

    예제 입력 1
    5 0
    -7 -3 -2 5 8

    예제 출력 1
    1
 */
public class Main15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int ans = 0;
        for (int i = 1; i < (1 << n); i++) { // 공집합은 제외해야하므로 1부터 시작
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += a[j];
                }
            }
            if (sum == s) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }

}
