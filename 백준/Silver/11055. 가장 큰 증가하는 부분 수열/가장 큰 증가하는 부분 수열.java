import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){
            dp[i] = nums[i];
            for(int j=i-1; j>=0; j--){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[j]+nums[i],dp[i]);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[N-1]);
    }
}
