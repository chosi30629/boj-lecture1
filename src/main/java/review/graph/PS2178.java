package review.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2178
public class PS2178 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void bfs(int[][] a, int[][] dist, int n, int m) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0));
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (dist[nx][ny] == 0 && a[nx][ny] == 1) {
                        q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] a = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(a, dist, n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dist[n-1][m-1]);
    }

}
