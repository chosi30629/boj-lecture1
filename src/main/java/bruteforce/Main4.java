package bruteforce;

import java.util.Scanner;

/*
    문제
        1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 다음에 오는 순열을 구하는 프로그램을 작성하시오.
        사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.
        N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.
        1, 2, 3
        1, 3, 2
        2, 1, 3
        2, 3, 1
        3, 1, 2
        3, 2, 1

    입력
        첫째 줄에 N(1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄에 순열이 주어진다.

    출력
        첫째 줄에 입력으로 주어진 순열의 다음에 오는 순열을 출력한다. 만약, 사전순으로 마지막에 오는 순열인 경우에는 -1을 출력한다.

    예제 입력 1
    4
    1 2 3 4
    예제 출력 1
    1 2 4 3

    예제 입력 2
    5
    5 4 3 2 1
    예제 출력 2
    -1
 */
public class Main4 {

    public static void next_per(int[] arr) {
        int a = 0;
        for (int i = arr.length - 1; i > 0 ; i--) {
            // 이전 순열은 이 조건의 기호만 바꿔야 함
            if (arr[i - 1] < arr[i]) {
                a = i;
                break;
            }
        }
        if (a <= 0) {
            System.out.println(-1);
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            // 이전 순열은 이 조건의 기호만 바꿔야 함
            if (arr[i] > arr[a - 1]) {
                int temp = arr[a - 1];
                arr[a - 1] = arr[i];
                arr[i] = temp;
                break;
            }
        }

        // a 뒤부터 맞바꾸기
        for (int j = arr.length - 1; a < j; j--) {
            int temp = arr[j];
            arr[j] = arr[a];
            arr[a] = temp;
            a++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int forCnt = scanner.nextInt();
        int[] arr = new int[forCnt];
        for (int i = 0; i < forCnt; i++) {
            arr[i] = scanner.nextInt();
        }
        next_per(arr);
    }

    /*
    public static boolean next_permutation(int[] a) {
        // ex) 7 2 3 6 5 4 1
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {   // 오른쪽부터 왼쪽이 작은 수를 찾는다. 3 < 6. i = 3
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {    // 오른쪽부터 i - 1 (3) 보다 큰 숫자 찾음 = 4
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;    // 3과 4 바꿈

        j = a.length-1;
        while (i < j) { // 바꾼 숫자의 오른쪽 뒤집음
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        if (next_permutation(a)) {
            for (int i=0; i<n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }
    */
}
