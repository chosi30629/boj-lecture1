package graph_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    문제
        영선이는 매우 기쁘기 때문에, 효빈이에게 스마일 이모티콘을 S개 보내려고 한다.
        영선이는 이미 화면에 이모티콘 1개를 입력했다. 이제, 다음과 같은 3가지 연산만 사용해서 이모티콘을 S개 만들어 보려고 한다.
        화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
        클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
        화면에 있는 이모티콘 중 하나를 삭제한다.
        모든 연산은 1초가 걸린다. 또, 클립보드에 이모티콘을 복사하면 이전에 클립보드에 있던 내용은 덮어쓰기가 된다. 클립보드가 비어있는 상태에는 붙여넣기를 할 수 없으며, 일부만 클립보드에 복사할 수는 없다. 또한, 클립보드에 있는 이모티콘 중 일부를 삭제할 수 없다. 화면에 이모티콘을 붙여넣기 하면, 클립보드에 있는 이모티콘의 개수가 화면에 추가된다.
        영선이가 S개의 이모티콘을 화면에 만드는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성하시오.

    입력
        첫째 줄에 S (2 ≤ S ≤ 1000) 가 주어진다.

    출력
        첫째 줄에 이모티콘을 S개 만들기 위해 필요한 시간의 최솟값을 출력한다.

    예제 입력 1
    2
    예제 출력 1
    2
    예제 입력 2
    4
    예제 출력 2
    4
    예제 입력 3
    6
    예제 출력 3
    5
    예제 입력 4
    18
    예제 출력 4
    8
 */
public class Main9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] d = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(0);
        d[1][0] = 0;    // 제일 처음에 이모티콘이 하나 있고 클립보드에는 없음, 시작은 0
        while (!q.isEmpty()) {
            int s = q.remove();
            int c = q.remove();
            if (d[s][s] == -1) {    // -1 이면 아직 방문하지 않음, 0 >= 이면 방문
                d[s][s] = d[s][c] + 1;
                q.add(s);
                q.add(s);
            }
            if (s+c <= n && d[s+c][c] == -1) {
                d[s+c][c] = d[s][c] + 1;
                q.add(s+c);
                q.add(c);
            }
            if (s-1 >= 0 && d[s-1][c] == -1) {
                d[s-1][c] = d[s][c] + 1;
                q.add(s-1);
                q.add(c);
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
        int ans = -1;   // 아직 최솟값을 구하지 못해 -1 로 초기화
        for (int i=0; i<=n; i++) {
            if (d[n][i] != -1) {
                if (ans == -1 || ans > d[n][i]) {   // -1 이면 그냥 넣어주고 아니라면 최솟값을 구했으니 넣음
                    ans = d[n][i];
                }
            }
        }
        System.out.println(ans);
    }

}
