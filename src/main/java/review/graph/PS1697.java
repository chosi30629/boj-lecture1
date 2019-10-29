package review.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1697
public class PS1697 {
    static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dist = new int[MAX];
        boolean[] check = new boolean[MAX];
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        check[n] = true;
        dist[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            if (now - 1 >= 0) {
                if (!check[now-1]) {
                    q.add(now - 1);
                    check[now-1] = true;
                    dist[now-1] = dist[now] + 1;
                }
            }
            if (now + 1 < MAX) {
                if (!check[now+1]) {
                    q.add(now + 1);
                    check[now+1] = true;
                    dist[now+1] = dist[now] + 1;
                }
            }
            if (now * 2 < MAX) {
                if (!check[now*2]) {
                    q.add(now * 2);
                    check[now*2] = true;
                    dist[now*2] = dist[now] + 1;
                }
            }
        }
        System.out.println(dist[m]);
    }

}
