package review.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/4963
public class PS4963 {
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    static void bfs(int[][] a, int[][] group, int x, int y, int cnt, int h, int w) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        group[x][y] = cnt;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            x = p.x;
            y = p.y;
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                        q.add(new Pair(nx, ny));
                        group[nx][ny] = cnt;
                    }
                }
            }
        }
    }

    static void dfs(int[][] a, int[][] group, int x, int y, int cnt, int h, int w) {
        group[x][y] = cnt;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                    dfs(a, group, nx, ny, cnt, h, w);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            if (w == 0 && h == 0) {
                break;
            }
            int[][] a = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }
            int[][] group = new int[h][w];
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (a[i][j] == 1 && group[i][j] == 0) {
                        bfs(a, group, i, j, ++cnt, h, w);
//                        dfs(a, group, i, j, ++cnt, h, w);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

}