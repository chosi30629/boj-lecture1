package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class Main8 {

    /*
    재귀함수 이용
     */
    public static ArrayList<Integer> lotto = new ArrayList<Integer>();
    public static void solve(int[] a, int index, int cnt) {
        if (cnt == 6) {
            for (int num : lotto) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        int n = a.length;
        if (n == index) {
            return;
        }
        lotto.add(a[index]);
        solve(a, index + 1, cnt + 1);
        lotto.remove(lotto.size() - 1);
        solve(a, index + 1, cnt);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int cnt = scanner.nextInt();
            if (cnt == 0) {
                break;
            }
            int[] a = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                a[i] = scanner.nextInt();
            }
            solve(a, 0, 0);
            System.out.println();
        }
    }





    /*
    순열 이용
    static boolean next_permutgetion(int[] arr) {
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
            int temp = arr[a];
            arr[a] = arr[i];
            arr[i] = temp;
            a++;
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            int[] d = new int[n];
            for (int i=0; i<n; i++) {
                if (i < n-6) d[i] = 0;
                else d[i] = 1;
            }
            ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
            do {
                ArrayList<Integer> cur = new ArrayList<Integer>();
                for (int i=0; i<n; i++) {
                    if (d[i] == 1) {
                        cur.add(a[i]);
                    }
                }
                ans.add(cur);
            } while (next_permutgetion(d));
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
                    int n = l1.size();
                    int m = l2.size();
                    int i = 0;
                    while (i < n && i < m) {
                        int t1 = l1.get(i);
                        int t2 = l2.get(i);
                        if (t1 < t2) return -1;
                        else if (t1 > t2) return 1;
                        i += 1;
                    }
                    if (i == n && i != m) return -1;
                    else if (i != n && i == m) return 1;
                    return 0;
                }
            });
            for (ArrayList<Integer> v : ans) {
                for (int x : v) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
     */

}
