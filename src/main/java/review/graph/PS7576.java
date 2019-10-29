package review.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/7576
public class PS7576 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<Pair> q = new LinkedList<Pair>();

    static void bfs(int[][] a, int[][] dist, int n, int m) {
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (a[nx][ny] == 0 && dist[nx][ny] == -1) {
                        q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] a = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
                dist[i][j] = -1;
                if (a[i][j] == 1) {
                    q.add(new Pair(i, j));
                    dist[i][j] = 0;
                }
            }
        }
        bfs(a, dist, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ans < dist[i][j]) {
                    ans = dist[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0 && dist[i][j] == -1) {
                    ans = -1;
                }
            }
        }
        System.out.println(ans);
    }

}
