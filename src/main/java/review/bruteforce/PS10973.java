package review.bruteforce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10973
public class PS10973 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (pre_permutation(a)) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean pre_permutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i-1] <= a[i]) {   // 다음 순열에서 부등호 바꾸기
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[j] >= a[i-1]) {            // 다음 순열에서 부등호 바꾸기
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }

}
