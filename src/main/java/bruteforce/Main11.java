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
public class Main11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int ans = go(arr, m, 0, 0);
        if (m == 0) {   // 공집합(0) 제외 - 1
            ans -= 1;
        }
        System.out.println(ans);
    }

    private static int go(int[] a, int m, int i, int sum) {
        if (i == a.length) {
            // 정답을 찾은 경우
            if (m == sum) {
                return 1;
            } else {
                // 더 이상 포함해야할지말지 결정해야하는 인덱스 수가 없다. 불가능
                return 0;
            }
        }
        // 다음 경우 - 부분집합에 포함한다, 안한다            포함하지 않는다도 어쨋들 결정했으니 i + 1, 합은 안더함
        return go(a, m, i + 1, sum + a[i]) + go(a, m, i + 1, sum);
    }

}
