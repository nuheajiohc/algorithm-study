import java.io.*;

public class Solution {

    static int[] div = {10, 100, 1000, 10000};
    static int[] dp = new int[100000];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=11; i<100000; i++){
            btk(i, i, 1, 0);
        }

        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++){
            int N = Integer.parseInt(br.readLine());
            sb.append("#").append(tc).append(" ").append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }

    static void btk(int target, int n, int value, int depth){
        if(n==0){
            dp[target] = Math.max(dp[target], dp[value]+1);
            return;
        }

        for(int i=0; i<4; i++){
            if(depth==0 && target<div[i]) continue;
            btk(target, n/div[i], value*(n%div[i]), depth+1);
        }
    }
}
