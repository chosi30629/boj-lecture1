package graph_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    문제
        수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
        수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

    입력
        첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

    출력
        수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

    예제 입력 1
    5 17
    예제 출력 1
    4
 */
public class Main8 {
    static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] dist = new int[MAX];
        boolean[] check = new boolean[MAX];
        dist[n] = 0;
        check[n] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            if (now - 1 >= 0) {
                move(dist, check, q, now, now - 1);
            }
            checkMax(dist, check, q, now, now + 1);
            checkMax(dist, check, q, now, now * 2);
        }
        System.out.println(dist[m]);
    }

    private static void checkMax(int[] dist, boolean[] check, Queue<Integer> q, int now, int i) {
        if (i < MAX) {
            move(dist, check, q, now, i);
        }
    }

    private static void move(int[] dist, boolean[] check, Queue<Integer> q, int now, int i) {
        if (check[i] == false) {
            q.add(i);
            check[i] = true;
            dist[i] = dist[now] + 1;
        }
    }

}
