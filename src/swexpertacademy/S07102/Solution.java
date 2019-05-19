package swexpertacademy.S07102;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test_case = 1; test_case <= t; test_case++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int arr[] = new int[M+N+1];
            int max = 0,max_int = 0;
            for (int m = 1;m<=M;m++){
                for (int n = 1;n<=N;n++){
                    arr[m+n]++;
                    if(max<=arr[m+n]){
                        max = arr[m+n];
                        max_int = m+n;
                    }
                }
            }
            String s = "";
            for (int i = 2;i<=M+N;i++){
                if(arr[i] == max)
                    s += i+" ";
            }
            System.out.println("#"+test_case+" "+s);
        }
    }
}
