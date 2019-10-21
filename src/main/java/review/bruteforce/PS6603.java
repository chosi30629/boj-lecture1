package review.bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/6603
public class PS6603 {
    static ArrayList<Integer> lotto = new ArrayList<Integer>();

    static void solve(int[] a, int index, int cnt) {
        if (cnt == 6) {
            for (int num : lotto) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        if (index >= a.length) {
            return;
        }

        // 인덱스번째를 선택한 경우
        lotto.add(a[index]);    // 사용한수 넣기
        solve(a,index + 1, cnt + 1);
        lotto.remove(lotto.size() - 1); // 모두 탐색한후 인덱스번째를 모두 선택한 경우이니 빼줌

        // 선택하지 않은 경우
        solve(a,index + 1, cnt);    // 선택하지 않는 경우를 먼저하면 사전순으로 나오지 않음
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            solve(a,0, 0);
            System.out.println();
        }
    }

}
