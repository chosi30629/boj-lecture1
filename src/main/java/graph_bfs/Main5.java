package graph_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    문제
        정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.
        한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다.
        두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 지도는 바다로 둘러쌓여 있으며, 지도 밖으로 나갈 수 없다.

    입력
        입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.
        둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
        입력의 마지막 줄에는 0이 두 개 주어진다.

    출력
        각 테스트 케이스에 대해서, 섬의 개수를 출력한다.

    예제 입력 1
    1 1
    0
    2 2
    0 1
    1 0
    3 2
    1 1 1
    1 1 1
    5 4
    1 0 1 0 0
    1 0 0 0 0
    1 0 1 0 1
    1 0 0 1 0
    5 4
    1 1 1 0 1
    1 0 1 0 1
    1 0 1 0 1
    1 0 1 1 1
    5 5
    1 0 1 0 1
    0 0 0 0 0
    1 0 1 0 1
    0 0 0 0 0
    1 0 1 0 1
    0 0
 */
public class Main5 {
    static int[] dx = {0, 0, -1, 1, -1, -1, 1 ,1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1 ,1};

    static void dfs(int[][] a, int[][] group, int x, int y, int cnt, int w, int h) {
        group[x][y] = cnt;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                    dfs(a, group, nx, ny, cnt, w, h);
                }
            }
        }
    }

    static void bfs(int[][] a, int[][] group, int x, int y, int cnt, int w, int h) {
        Queue<Pair1> q = new LinkedList<Pair1>();
        q.add(new Pair1(x, y));
        group[x][y] = cnt;
        while (!q.isEmpty()) {
            Pair1 pair = q.remove();
            x = pair.x;
            y = pair.y;
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                        q.add(new Pair1(nx, ny));
                        group[nx][ny] = cnt;
                    }
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
            int cnt = 0;
            int[][] group = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (a[i][j] == 1 && group[i][j] == 0) {
//                        dfs(a, group, i, j, ++cnt, w, h);
                        bfs(a, group, i, j, ++cnt, w, h);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

}

class Pair1 {
    int x;
    int y;

    public Pair1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}