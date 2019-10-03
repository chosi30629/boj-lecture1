package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

/*
    문제
        N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
        |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|

    입력
        첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다. 둘째 줄에는 배열 A에 들어있는 정수가 주어진다. 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.

    출력
        첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.

    예제 입력 1
    6
    20 1 15 8 4 10

    예제 출력 1
    62
 */
public class Main6 {

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
        for (int i = arr.length - 1; a < i ; i--) {
            int temp = arr[i];
            arr[i] = arr[a];
            arr[a] = temp;
            a++;
        }
        System.out.println(Arrays.toString(arr));
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int temp = 0;
        do {
            int sum = 0;
            for (int i = 1; i < arr.length; i++) {
                // | | 는  절댓값 기호...
                sum += Math.abs(arr[i - 1] - arr[i]);
            }
            temp = Math.max(temp, sum);
        } while (per(arr));
        System.out.println(temp);
    }

}
