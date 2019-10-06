package bruteforce_n_and_m;

import java.util.Scanner;

/*
    문제
        자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
        1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        고른 수열은 오름차순이어야 한다.
    입력
        첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

    출력
        한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
        수열은 사전 순으로 증가하는 순서로 출력해야 한다.

    예제 입력 1
    3 1
    예제 출력 1
    1
    2
    3

    예제 입력 2
    4 2
    예제 출력 2
    1 2
    1 3
    1 4
    2 3
    2 4
    3 4

    예제 입력 3
    4 4
    예제 출력 3
    1 2 3 4
 */
public class Main2 {
    static int[] a = new int[10];
    static boolean[] c = new boolean[10];

    static void go(int index, int selected, int n, int m) {
        if (selected == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }
        if (index > n) {
            return;
        }
        a[selected] = index;
        go(index + 1, selected + 1, n, m);
        a[selected] = 0;
        go(index + 1, selected, n, m);
    }

    /*
    static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            if (c[i]) {
                continue;
            }
            c[i] = true;
            a[index] = i;
            go(index + 1, i + 1, n, m);
            c[i] = false;
        }
    }
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
//        go(0, 1, n, m);
        go(1, 0, n, m);
    }

}
