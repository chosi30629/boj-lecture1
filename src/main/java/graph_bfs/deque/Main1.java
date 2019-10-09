package graph_bfs.deque;

import java.util.*;

/*
    문제
        수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
        수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

    입력
        첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

    출력
        수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

    예제 입력 1
    5 17
    예제 출력 1
    2

    힌트
    수빈이가 5-10-9-18-17 순으로 가면 2초만에 동생을 찾을 수 있다.
 */
public class Main1 {
    static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] dist = new int[MAX];
        boolean[] check = new boolean[MAX];
        dist[n] = 0;
        check[n] = true;
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now * 2 < MAX) {    // * 가 제일 먼저 나와야함..... 0 초부터 먼저 처리
                if (!check[now * 2]) {
                    q.addFirst(now * 2);
                    check[now * 2] = true;
                    dist[now * 2] = dist[now];
                }
            }
            if (now - 1 >= 0) {
                if (!check[now - 1]) {
                    q.addLast(now - 1);
                    check[now - 1] = true;
                    dist[now - 1] = dist[now] + 1;
                }
            }
            if (now + 1 < MAX) {
                if (!check[now + 1]) {
                    q.addLast(now + 1);
                    check[now + 1] = true;
                    dist[now + 1] = dist[now] + 1;
                }
            }

        }
        System.out.println(dist[m]);
    }

}

/*
큐 두개 이용

public class Main {
    public static final int MAX = 1000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] c = new boolean[MAX];
        int[] d = new int[MAX];
        c[n] = true;
        d[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> next_queue = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : new int[]{now*2, now-1, now+1}) {
                if (next >= 0 && next < MAX) {
                    if (c[next] == false) {
                        c[next] = true;
                        if (now*2 == next) {
                            q.add(next);
                            d[next] = d[now];
                        } else {
                            next_queue.add(next);
                            d[next] = d[now] + 1;
                        }
                    }
                }
            }
            if (q.isEmpty()) {
                q = next_queue;
                next_queue = new LinkedList<Integer>();
            }
        }
        System.out.println(d[m]);
    }
}
 */