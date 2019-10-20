package review.bruteforce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10974
public class PS10974 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
            System.out.print(a[i] + " ");
        }
        System.out.println();
        while (true) {
            if (next_permutation(a)) {
                for (int i = 0; i < n; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println();
            } else {
                break;
            }
        }
    }

    static boolean next_permutation(int[] a) {
        int length = a.length - 1;
        int i = length;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }

        int j = length;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[j];
        a[j] = a[i-1];
        a[i-1] = temp;

        j = length;
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
