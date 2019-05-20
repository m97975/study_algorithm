package swexpertacademy.S01204;

import java.util.Scanner;

public class Solution {
    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for (int t = 1; t <= test_case; t++) {
            int arr[] = new int[101];
            for (int i = 0; i < 1000; i++) {
                int input = sc.nextInt();
                arr[input]++;
            }
            int res = 0;
            int res_n = 0;
            for (int i = 0; i < 101; i++) {
                int chk = arr[i];
                if()
                res = Math.max(res, arr[i]);
            }
            System.out.println("#" + test_case + " " + res);
        }
    }
}
