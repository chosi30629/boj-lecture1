package graph_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    문제
        사악한 암흑의 군주 이민혁은 드디어 마법 구슬을 손에 넣었고, 그 능력을 실험해보기 위해 근처의 티떱숲에 홍수를 일으키려고 한다. 이 숲에는 고슴도치가 한 마리 살고 있다. 고슴도치는 제일 친한 친구인 비버의 굴로 가능한 빨리 도망가 홍수를 피하려고 한다.
        티떱숲의 지도는 R행 C열로 이루어져 있다. 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다. 비버의 굴은 'D'로, 고슴도치의 위치는 'S'로 나타내어져 있다.
        매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다. (위, 아래, 오른쪽, 왼쪽) 물도 매 분마다 비어있는 칸으로 확장한다. 물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 물과 고슴도치는 돌을 통과할 수 없다. 또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.
        티떱숲의 지도가 주어졌을 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하는 프로그램을 작성하시오.
        고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다. 이동할 수 있으면 고슴도치가 물에 빠지기 때문이다.

    입력
        첫째 줄에 50보다 작거나 같은 자연수 R과 C가 주어진다.
        다음 R개 줄에는 티떱숲의 지도가 주어지며, 문제에서 설명한 문자만 주어진다. 'D'와 'S'는 하나씩만 주어진다.

    출력
        첫째 줄에 고슴도치가 비버의 굴로 이동할 수 있는 가장 빠른 시간을 출력한다. 만약, 안전하게 비버의 굴로 이동할 수 없다면, "KAKTUS"를 출력한다.

    예제 입력 1
    3 3
D.*
...
.S.
    예제 출력 1
    3

    예제 입력 2
    3 3
D.*
...
..S
    예제 출력 2
    KAKTUS

    예제 입력 3
    3 6
D...*.
.X.X..
....S.
    예제 출력 3
    6
 */
public class Main11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        String[] a = new String[n];
        int[][] water = new int[n][m];
        int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                water[i][j] = -1;
                d[i][j] = -1;
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<Pair> q = new LinkedList<Pair>();
        int sx = 0;
        int sy = 0;
        int ex = 0;
        int ey = 0;
        // 물 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i].charAt(j) == '*') {        // 물을 0으로
                    q.add(new Pair(i, j));
                    water[i][j] = 0;
                } else if (a[i].charAt(j) == 'S') { // 고슴도치 위치
                    sx = i;
                    sy = j;
                } else if (a[i].charAt(j) == 'D') { // 동굴 위치
                    ex = i;
                    ey = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
        // 매분마다 물 차오르게 하기
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (water[nx][ny] != -1) {      // 물
                        continue;
                    }
                    if (a[nx].charAt(ny) == 'X') {  // 돌
                        continue;
                    }
                    if (a[nx].charAt(ny) == 'D') {  // 동굴
                        continue;
                    }
                    water[nx][ny] = water[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
        q.add(new Pair(sx, sy));
        d[sx][sy] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (d[nx][ny] != -1) {
                        continue;
                    }
                    if (a[nx].charAt(ny) == 'X') {
                        continue;
                    }
                    if (water[nx][ny] != -1 && d[x][y] + 1 >= water[nx][ny]) {
                        continue;
                    }
                    d[nx][ny] = d[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
        if (d[ex][ey] == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(d[ex][ey]);
        }
    }

}
