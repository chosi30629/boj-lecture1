package review.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1759
public class PS1759 {

    static boolean check(String password) {
        int mo = 0;
        int ja = 0;
        for (char c : password.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mo++;
            } else {
                ja++;
            }
        }
        return mo >= 1 && ja >= 2;
    }

    // n = 만들어야 하는 암호의 길이, alpha = 사용할 수 있는 알파벳, password = 암호, i = 인덱스
    static void go(int n, String[] alpha, String password, int i) {
        if (n == password.length()) {
            if (check(password)) {  // 조건에 맞게 정답을 찾은 경우
                System.out.println(password);
            }
            return;
        }

        /*
        if (i >= alpha.length) {    // 불가능한 경우, 불가능 한 경우가 위에 오면 틀릴 수가 있음.
            return;
        }

        // 다음 경우
        go(n, alpha, password + alpha[i], i+1); // i번째 알파벳을 사용한다. 4개가 채워진후 리턴하고 맨뒤에서부터 하나씩 지워지면서 인덱스가 돌며 패스워드가 바뀌어짐.
        go(n, alpha, password, i+1);            // i번째 알파벳을 사용하지 않는다. 암호가 그대로 있음.
         */

        if (i < alpha.length) {
            go(n, alpha, password + alpha[i], i+1);
            go(n, alpha, password, i+1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();
        String[] alpha = new String[c];
        String[] s = scanner.nextLine().split(" ");
        for (int i = 0; i < c; i++) {
            alpha[i] = s[i];
        }
        Arrays.sort(alpha);
        go(l, alpha, "", 0);
    }

}
