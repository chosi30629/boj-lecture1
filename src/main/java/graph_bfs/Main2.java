package graph_bfs;

import java.util.*;

/*
    문제
        방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

    입력
        첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

    출력
        첫째 줄에 연결 요소의 개수를 출력한다.

    예제 입력 1
    6 5
    1 2
    2 5
    5 1
    3 4
    4 6
    예제 출력 1
    2

    예제 입력 2
    6 8
    1 2
    2 5
    5 1
    3 4
    4 6
    5 4
    2 4
    2 3
    예제 출력 2
    1
 */
public class Main2 {

    static void dfs(ArrayList<Integer>[] a, boolean[] c, int x) {
        if (c[x]) {
            return;
        }
        c[x] = true;
        for (int y : a[x]) {
            if (!c[y]) {
                dfs(a, c, y);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        boolean[] check = new boolean[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {  // 연결이 되어 있지 않아 1부터 정점의 갯수까지 탐색을 반복해야 함
            if (!check[i]) {
                dfs(a, check, i);
                ans += 1;
            }
        }
        System.out.println(ans);
    }

}
