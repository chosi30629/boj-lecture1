package review.graph;

import java.util.*;

// https://www.acmicpc.net/problem/1260
public class PS1260 {
    static ArrayList<Integer>[] a;
    static boolean[] c;

    static void dfs(int x) {
        if (c[x]) {
            return;
        }
        c[x] = true;
        System.out.print(x + " ");
        for (int y : a[x]) {
            if (!c[y]) {
                dfs(y);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        c[start] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");
            for (int y : a[x]) {
                if (!c[y]) {
                    c[y] = true;
                    q.add(y);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int start = scanner.nextInt();
        a = (ArrayList<Integer>[]) new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(a[i]);
        }
        c = new boolean[n+1];
        dfs(start);
        System.out.println();
        c = new boolean[n+1];
        bfs(start);
    }

}
