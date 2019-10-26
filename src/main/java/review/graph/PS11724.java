package review.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11724
public class PS11724 {
    static ArrayList<Integer>[] a;
    static boolean[] c;

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        c[start] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
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
        c = new boolean[n+1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!c[i]) {
                bfs(i);
                ans += 1;
            }
        }
        System.out.println(ans);
    }

}
