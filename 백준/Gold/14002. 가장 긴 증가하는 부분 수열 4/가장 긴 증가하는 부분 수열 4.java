import java.io.*;
import java.util.*;

public class Main {

    private static int[] nums,dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[N];
        Arrays.fill(dp,1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int index=0;
        int maxValue=dp[0];
        
        for(int i=0; i<N; i++){
            if(dp[i]>maxValue){
                index=i;
                maxValue = dp[i]; 
            }
        }
        List<Integer> result = new ArrayList<>();

        int temp = maxValue;
        while(index>=0){
            if(dp[index]==temp){
                result.add(nums[index]);
                temp--;
            }
            index--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=maxValue-1; i>=0; i--){
            sb.append(result.get(i)).append(" ");
        }

        System.out.println(maxValue);
        System.out.println(sb.toString());
    }
}
