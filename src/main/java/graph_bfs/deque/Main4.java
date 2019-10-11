package graph_bfs.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] a = new int[n][m];
        int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = -1;
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Deque<Pair2> q = new ArrayDeque<Pair2>();
        d[0][0] = 0;
        q.add(new Pair2(0, 0));
        while (!q.isEmpty()) {
            Pair2 p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (d[nx][ny] == -1) {
                        if (a[nx][ny] == 0) {
                            d[nx][ny] = d[x][y];
                            q.addFirst(new Pair2(nx, ny));
                        } else {
                            d[nx][ny] = d[x][y] + 1;
                            q.addLast(new Pair2(nx, ny));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(d[n-1][m-1]);
    }

}
