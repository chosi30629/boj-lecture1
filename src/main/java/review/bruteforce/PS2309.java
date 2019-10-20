package review.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2309
public class PS2309 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[9];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
            sum += a[i];
        }
        Arrays.sort(a);
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - a[i] - a[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (a[k] == a[i] || a[k] == a[j]) {
                            continue;
                        }
                        System.out.println(a[k]);
                    }
                    System.exit(0); // 종료
                }
            }
        }
    }

}
