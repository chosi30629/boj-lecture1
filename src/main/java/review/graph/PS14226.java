package review.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/14226
public class PS14226 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] d = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(1, 0));
        d[1][0] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int screen = p.x;
            int clipboard = p.y;
            if (d[screen][screen] == -1) {  // 복사
                d[screen][screen] = d[screen][clipboard] + 1;
                q.add(new Pair(screen, screen));
            }
            if (screen + clipboard <= n && d[screen+clipboard][clipboard] == -1) {  // 붙여넣기
                d[screen+clipboard][clipboard] = d[screen][clipboard] + 1;
                q.add(new Pair(screen + clipboard, clipboard));
            }
            if (screen - 1 >= 0 && d[screen-1][clipboard] == -1) {  // 삭제
                d[screen-1][clipboard] = d[screen][clipboard] + 1;
                q.add(new Pair(screen - 1, clipboard));
            }
        }
        int ans = -1;   // 아직 최솟값을 구하지 못했다는 의미 -1
        for (int i = 0; i <= n; i++) {
            if (d[n][i] != -1) {
                if (ans == -1 || ans > d[n][i]) {   // -1 이면 값 넣고 아니면 최솟값을 구한거니 비교해서 최소값을 넣는다...
                    ans = d[n][i];
                }
            }
        }
        System.out.println(ans);
    }

}

