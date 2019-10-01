package math;

import java.util.Scanner;

/*

    문제
        M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

    입력
        첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)

    출력
        한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

    예제 입력 1
    3 16

    예제 출력 1
    3
    5
    7
    11
    13
 */
public class Main6 {

    // 에라토스테네스의 체 활용
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] check = new boolean[m+1];
        check[0] = check[1] = true;
        for (int i=2; i*i <= m; i++) {
            if (check[i] == true) {
                continue;
            }
            for (int j=i+i; j<=m; j+=i) {
                check[j] = true;
            }
        }
        for (int i=n; i<=m; i++) {
            if (check[i] == false) {
                System.out.println(i);
            }
        }
    }
    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNo = scanner.nextInt();
        int endNo = scanner.nextInt();
        int[] noArr = new int[endNo];
        for (int i = 0; i < noArr.length; i++) {
            noArr[i] = i+ 1;
        }
        boolean[] checkArr = new boolean[endNo];
        for (int i = 0; i < noArr.length; i++) {
            if (prime(noArr[i])) {
                checkArr[i] = true;
            }
        }
        for (int i = 0; i < checkArr.length; i++) {
            if (checkArr[i] && (noArr[i] >= startNo && noArr[i] <= endNo)) {
                System.out.println(noArr[i]);
            }
        }

    }

    public static boolean prime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    */
}
