package swexpertacademy.S07103;
import java.util.Scanner;

public class Solution {
    static int N, case_result;
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case<=T;test_case++){
            N = sc.nextInt();
            case_result = 0;
            int sq = (int) Math.sqrt(N);
            next(0, sq,0);
            System.out.println("#"+test_case+" "+case_result);
        }
    }
    static void next(int next_int,int n,int step){
        if(step>4)return;
        if(next_int == N) {
            case_result++;
            return;
        }
        for (int i = n;i>=1;i--){
            if(next_int+(i*i)>N)continue;
            int chk = N-(next_int+(i*i));
            int sqt = (int) Math.sqrt(chk)+1;
            next(next_int+(i*i),sqt,step+1);
        }
    }
}
