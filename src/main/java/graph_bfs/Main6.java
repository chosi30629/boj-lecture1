package graph_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    문제
        N×M크기의 배열로 표현되는 미로가 있다.
        1	0	1	1	1	1
        1	0	1	0	1	0
        1	0	1	0	1	1
        1	1	1	0	1	1
        미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
        위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

    입력
        첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

    출력
        첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

    예제 입력 1
    4 6
    101111
    101010
    101011
    111011
    예제 출력 1
    15
    예제 입력 2
    4 6
    110110
    110110
    111111
    111101
    예제 출력 2
    9
    예제 입력 3
    2 25
    1011101110111011101110111
    1110111011101110111011101
    예제 출력 3
    38
    예제 입력 4
    7 7
    1011111
    1110001
    1000001
    1000001
    1000001
    1000001
    1111111
    예제 출력 4
    13
 */
public class Main6 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void bfs(int[][] a, int[][] group, boolean[][] check, int x, int y, int n, int m) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        group[x][y] = 1;
        check[x][y] = true;
        while (!q.isEmpty()) {
            Pair pair = q.remove();
            x = pair.x;
            y = pair.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (a[nx][ny] == 1 && !check[nx][ny]) {
                        q.add(new Pair(nx, ny));
                        group[nx][ny] = group[x][y] + 1;
                        check[nx][ny] = true;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[n][m];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int[][] group = new int[n][m];
        boolean[][] check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 && group[i][j] == 0) {
                    bfs(a, group, check, i, j, n, m);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(group[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(group[n - 1][m - 1]);
    }

}

/*
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void bfs(int[][] a, int[][] group, int x, int y, int n, int m) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        group[x][y] = 1;
        while (!q.isEmpty()) {
            Pair pair = q.remove();
            x = pair.x;
            y = pair.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                        q.add(new Pair(nx, ny));
                        group[nx][ny] = group[x][y] + 1;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[n][m];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int[][] group = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 && group[i][j] == 0) {
                    bfs(a, group, i, j, n, m);
                }
            }
        }
        System.out.println(group[n - 1][m - 1]);
    }

}

 */