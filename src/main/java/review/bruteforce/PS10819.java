package review.bruteforce;


import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/10819
public class PS10819 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a); // 처음 순열부터 비교해야하기 때문에 순서 초기화를 위한 정렬
        int ans = 0;
        do {
            ans = Math.max(ans, calc(a));
        } while (next_permutation(a));

        System.out.println(ans);
    }

    private static boolean next_permutation(int[] a) {
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

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

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

    private static int calc(int[] a) {
        int sum = 0;
        for (int i = 1; i < a.length; i++) {
            sum += Math.abs(a[i-1] - a[i]);
        }
        return sum;
    }

}
