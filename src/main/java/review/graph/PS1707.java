package review.graph;

import java.util.*;

// https://www.acmicpc.net/problem/1707
public class PS1707 {

    static void dfs(ArrayList<Integer>[] a, int[] color, int x, int c) {
        color[x] = c;
        for (int y : a[x]) {
            if (color[y] == 0) {
                dfs(a, color, y, 3 - c);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                a[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                a[u].add(v);
                a[v].add(u);
            }
            int[] color = new int[n+1];
            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) {
                    dfs(a, color, i, 1);
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j : a[i]) {
                    if (color[i] == color[j]) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
