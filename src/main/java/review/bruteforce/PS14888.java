package review.bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/14888
// 15658 과 정답 같음
public class PS14888 {

    static Pair solve(int[] a, int index, int cur, int plus, int minus, int mul, int div) {
        int n = a.length;
        if (index == n) {
            return new Pair(cur, cur);
        }
        ArrayList<Pair> res = new ArrayList<Pair>();    // 최댓값과 최솟값을 찾기 위해 결과값들을 저장하는 리스트
        if (plus > 0) {
            res.add(solve(a, index + 1, cur + a[index], plus - 1, minus, mul, div));
        }
        if (minus > 0) {
            res.add(solve(a, index + 1, cur - a[index], plus, minus - 1, mul, div));
        }
        if (mul > 0) {
            res.add(solve(a, index + 1, cur * a[index], plus, minus, mul - 1, div));
        }
        if (div > 0) {
            res.add(solve(a, index + 1, cur / a[index], plus, minus, mul, div - 1));
        }
        Pair ans = res.get(0);
        for (Pair p : res) {
            if (ans.max < p.max) {
                ans.max = p.max;
            }
            if (ans.min > p.min) {
                ans.min = p.min;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int plus = scanner.nextInt();
        int minus = scanner.nextInt();
        int mul = scanner.nextInt();
        int div = scanner.nextInt();

        // 처음에 a[0] a[1] 사이에 연산자를 끼워 넣어야 해서 1로 시작
        Pair ans = solve(a, 1, a[0], plus, minus, mul, div);
        System.out.println(ans.max);
        System.out.println(ans.min);
    }

}

class Pair {
    int max;
    int min;

    public Pair(int max, int min) {
        this.max = max;
        this.min = min;
    }
}