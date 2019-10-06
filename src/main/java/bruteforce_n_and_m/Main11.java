package bruteforce_n_and_m;

import java.util.Arrays;
import java.util.Scanner;

/*
    문제
        N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
        N개의 자연수 중에서 M개를 고른 수열
        같은 수를 여러 번 골라도 된다.

    입력
        첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
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
    1 1
    1 7
    1 9
    7 1
    7 7
    7 9
    9 1
    9 7
    9 9
 */
public class Main11 {
    static int[] a = new int[10];
    static int[] num = new int[10];

    static StringBuffer sb = new StringBuffer();

    static void go(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            a[index] = num[i];
            go(index + 1, n, m);
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
        for (int i = 1; i < n; i++) {
            if (temp[i] != x) {
                num[k] = x;
                k += 1;
                x = temp[i];
            }
        }
        num[k] = x;
        n = k + 1;
        go(0, n, m);
        System.out.println(sb.toString());
    }

}
