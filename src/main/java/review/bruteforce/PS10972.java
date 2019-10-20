package review.bruteforce;


import java.util.Scanner;

// https://www.acmicpc.net/problem/10972
public class PS10972 {

    static boolean next_permutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i-1] >= a[i]) {   // 왼쪽으로 한칸씩 이동하며 제일 오른쪽의 수보다 작은 수를 찾는다. (제일 오른쪽의 수보다 작으면서 가장 가까운 수)
            i -= 1;
        }

        if (i <= 0) {                       // 0까지 없으면 다음 순열 없음
            return false;
        }

        int j = a.length - 1;
        while (a[j] <= a[i-1]) {            // 왼쪽으로 한칸씩 이동하며 위에서 찾은 수보다 큰 수를 찾는다. (가장 오른쪽에 있으면서 위에서 찾은 수보다 큰 수)
            j -= 1;
        }

        int temp = a[i-1];                  // 둘을 스왑
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {                     // 위에서 찾은 수보다 한칸 오른쪽수부터(오른쪽으로 증가) 제일 오른쪽 수의 숫자(왼쪽으로 감소)를 스왑
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (next_permutation(a)) {          // 다음 순열
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

}
