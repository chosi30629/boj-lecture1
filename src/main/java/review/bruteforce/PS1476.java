package review.bruteforce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1476
public class PS1476 {

    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int e = scanner.nextInt();
        int s = scanner.nextInt();
        int m = scanner.nextInt();
        int a = 0;
        int b = 0;
        int c = 0;
        int n = 0;
        while (true) {
            n++;
            a++;
            b++;
            c++;
            if (a == 16) {
                a = 1;
            }
            if (b == 29) {
                b = 1;
            }
            if (c == 20) {
                c = 1;
            }
            if (a == e && b == s && c == m) {
                break;
            }
        }
        System.out.println(n);
    }
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int e = scanner.nextInt() - 1;
        int m = scanner.nextInt() - 1;
        int s = scanner.nextInt() - 1;
        for (int i = 0; ; i++) {
            if (i % 15 == e && i % 28 == m && i % 19 == s) {
                System.out.println(i + 1);
                break;
            }
        }
    }

}
