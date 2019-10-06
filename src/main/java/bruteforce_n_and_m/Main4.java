package bruteforce_n_and_m;

import java.util.Scanner;

/*
    문제
        자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
        1부터 N까지 자연수 중에서 M개를 고른 수열
        같은 수를 여러 번 골라도 된다.
        고른 수열은 비내림차순이어야 한다.
        길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.

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
    1 1
    1 2
    1 3
    1 4
    2 2
    2 3
    2 4
    3 3
    3 4
    4 4

    예제 입력 3
    3 3
    예제 출력 3
    1 1 1
    1 1 2
    1 1 3
    1 2 2
    1 2 3
    1 3 3
    2 2 2
    2 2 3
    2 3 3
    3 3 3
 */
public class Main4 {
//    static int[] a = new int[10];
    static int[] cnt = new int[10];

    static StringBuilder go(int index, int selected, int n, int m) {
        if (selected == m) {
            StringBuilder sb = new StringBuilder();
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=cnt[i]; j++) {
                    sb.append(i);
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        if (index > n) return ans;
        for (int i=m-selected; i>=1; i--) {
            cnt[index] = i;
            ans.append(go(index+1, selected+i, n, m));
        }
        cnt[index] = 0;
        ans.append(go(index+1, selected, n, m));
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.print(go(1, 0, n, m));
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
        if (index > n) {
            return;
        }

        for (int i = start; i <= n; i++) {
            a[index] = i;
            go(index + 1, i, n, m);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
//        go(0, 1, n, m);
    }
    */
}
