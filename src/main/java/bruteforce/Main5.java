package bruteforce;

import java.util.Scanner;

/*
    문제
        N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.

    입력
        첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.

    출력
        첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.

    예제 입력 1
    3

    예제 출력 1
    1 2 3
    1 3 2
    2 1 3
    2 3 1
    3 1 2
    3 2 1
 */
public class Main5 {

    public static boolean per(int[] arr) {
        int a = 0;
        for (int i = arr.length - 1; i > 0 ; i--) {
            if (arr[i - 1] < arr[i]) {
                a = i;
                break;
            }
        }
        if (a <= 0) {
            return false;
        }
        for (int i = arr.length - 1; i > 0 ; i--) {
            if (arr[a - 1] < arr[i]) {
                int temp = arr[i];
                arr[i] = arr[a - 1];
                arr[a - 1] = temp;
                break;
            }
        }
        for (int i = arr.length - 1; a < i; i--) {
            int temp = arr[a];
            arr[a] = arr[i];
            arr[i] = temp;
            a++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] noArr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            noArr[i] = i + 1;
        }
        do {
            for (int i = 0; i < noArr.length; i++) {
                System.out.print(noArr[i] + " ");
            }
            System.out.println();
        } while (per(noArr));
    }

}
