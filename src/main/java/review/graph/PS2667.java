package review.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2667
public class PS2667 {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    static void bfs(int[][] a, int[][] group, int x, int y, int cnt, int n) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        group[x][y] = cnt;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            x = p.x;
            y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                        q.add(new Pair(nx, ny));
                        group[nx][ny] = cnt;
                    }
                }
            }
        }
    }

    static void dfs(int[][] a, int[][] group, int x, int y, int cnt, int n) {
        group[x][y] = cnt;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                    dfs(a, group, nx, ny, cnt, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int cnt = 0;
        int[][] group = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && group[i][j] == 0) {
                    bfs(a, group, i, j, ++cnt, n);
//                    dfs(a, group, i, j, ++cnt, n);
                }
            }
        }
        int[] ans = new int[cnt];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] != 0) {
                    ans[group[i][j]-1] += 1;
                }
            }
        }
        Arrays.sort(ans);
        System.out.println(cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.println(ans[i]);
        }
    }

}
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}