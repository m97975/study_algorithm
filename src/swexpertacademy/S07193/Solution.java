package swexpertacademy.S07193;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            double X = sc.nextDouble();
            System.out.println("#" + test_case + " "+math(N,X));
        }
    }
    static double math(int n, double res) {
        double total = 0;
        while (true) {
            total += res % 10;
            res = res / 10 - (res / 10-(int)(res / 10));
            if (res == 0) break;
        }

        double res_s = 0;
        int i = 1;

        while (true) {
            res_s += (total % n) * i;
            total /= n;
            i *= 10;
            if(total == 0)break;
        }
        if(res_s == (n-1)) return 0;
        else if(res_s < (n-1)) return res_s;
        return math(n,res_s);
    }
}
