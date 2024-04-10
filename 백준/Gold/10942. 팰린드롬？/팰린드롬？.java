import java.io.*;
import java.util.*;

public class Main {
    private static int[] nums;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1;j<=N-i+1; j++){
                dp[i][j] = isTrue(i,j) ? 1: 0;
            }
        }

        StringBuilder sb= new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[e-s+1][s]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean isTrue(int i, int j){
        int st =j;
        int en =i+j-1;
        while(st<en){
            if(nums[st++]!= nums[en--]) return false;
        }
        return true;
    }
}
