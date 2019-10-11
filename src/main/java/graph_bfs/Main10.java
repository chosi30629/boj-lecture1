package graph_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    문제
        N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
        만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.
        맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

    입력
        첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.

    출력
        첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.

    예제 입력 1
    6 4
    0100
    1110
    1000
    0000
    0111
    0000
    예제 출력 1
    15

    예제 입력 2
    4 4
    0111
    1111
    1111
    1110
    예제 출력 2
    -1
 */
public class Main10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int[][][] d = new int[n][m][2];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<Pair5> q = new LinkedList<Pair5>();
        d[0][0][0] = 1; // 행, 열, 벽을 부순 횟수, 1칸을 방문했으니 1이라고 함
        q.add(new Pair5(0, 0, 0));
        while (!q.isEmpty()) {
            Pair5 p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (a[nx][ny] == 0 && d[nx][ny][z] == 0) { // 다음칸이 빈칸이고 다음칸을 방문한적이 없으면 방문
                        d[nx][ny][z] = d[x][y][z] + 1;
                        q.add(new Pair5(nx, ny, z));
                    }
                    if (z == 0 && a[nx][ny] == 1 & d[nx][ny][z+1] == 0) { // 다음칸이 벽이고 벽을 부순 횟수가 없고 그 다음칸 방문 한적 없으면
                        d[nx][ny][z+1] = d[x][y][z] + 1;    // 벽을 부쉈으므로 z + 1
                        q.add(new Pair5(nx, ny,z + 1));
                    }
                }
            }
        }
        // 벽을 부순게 정답인지 안부순게 정답인지 몰라 4가지 조건
        if (d[n-1][m-1][0] !=0 && d[n-1][m-1][1] != 0) {
            System.out.println(Math.min(d[n-1][m-1][0], d[n-1][m-1][1]));
        } else if (d[n-1][m-1][0] != 0) {
            System.out.println(d[n-1][m-1][0]);
        } else if (d[n-1][m-1][1] != 0) {
            System.out.println(d[n-1][m-1][1]);
        } else {
            System.out.println(-1);
        }
    }

}

class Pair5 {
    int x;
    int y;
    int z;

    public Pair5(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}