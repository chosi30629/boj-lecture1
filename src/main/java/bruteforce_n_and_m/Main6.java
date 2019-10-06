package bruteforce_n_and_m;

import java.util.Arrays;
import java.util.Scanner;

/*
    문제
        N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
        N개의 자연수 중에서 M개를 고른 수열
        고른 수열은 오름차순이어야 한다.

    입력
        첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
        둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

    출력
        한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
        수열은 사전 순으로 증가하는 순서로 출력해야 한다.

    예제 입력 1
    3 1
    4 5 2
    예제 출력 1
    2
    4
    5

    예제 입력 2
    4 2
    9 8 7 1
    예제 출력 2
    1 7
    1 8
    1 9
    7 8
    7 9
    8 9

    예제 입력 3
    4 4
    1231 1232 1233 1234
    예제 출력 3
    1231 1232 1233 1234
 */
public class Main6 {
    static int[] a;
    static int[] b = new int[10];
    static boolean[] c = new boolean[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        go(0, 0, n, m);
    }

    private static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(b[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < n; i++) {
            if (c[i]) {
                continue;
            }
            c[i] = true;
            b[index] = a[i];
            go(index + 1, i, n, m);
            c[i] = false;
        }
    }

}
