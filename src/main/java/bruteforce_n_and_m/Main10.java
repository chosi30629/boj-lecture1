package bruteforce_n_and_m;

import java.util.Arrays;
import java.util.Scanner;

/*
    문제
        N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
        N개의 자연수 중에서 M개를 고른 수열
        고른 수열은 비내림차순이어야 한다.
        길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.

    입력
        첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
        둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

    출력
        한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
        수열은 사전 순으로 증가하는 순서로 출력해야 한다.

    예제 입력 1
    3 1
    4 4 2
    예제 출력 1
    2
    4

    예제 입력 2
    4 2
    9 7 9 1
    예제 출력 2
    1 7
    1 9
    7 9
    9 9

    예제 입력 3
    4 4
    1 1 2 2
    예제 출력 3
    1 1 2 2
 */
public class Main10 {
    static int[] a = new int[10];
    static int[] num = new int[10];
    static int[] cnt = new int[10];

    public static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            if (cnt[i] > 0) {
                cnt[i] -= 1;
                a[index] = num[i];
                go(index + 1, i, n, m);
                cnt[i] += 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = scanner.nextInt();
        }
        Arrays.sort(temp);

        int k = 0;
        int x = temp[0];
        int c = 1;
        for (int i = 1; i < n; i++) {
            if (temp[i] == x) {
                c += 1;
            } else {
                cnt[k] = c;
                num[k] = x;
                k += 1;
                x = temp[i];
                c = 1;
            }
        }
        num[k] = x;
        cnt[k] = c;
        n = k + 1;
        go(0,0, n , m);
    }

}
