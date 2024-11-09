import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++){
            int cur = calCount(i);
            dp[i] = dp[i-1] + cur;
        }

        System.out.println(dp[N]);
    }

    public static int calCount(int target){
        int count=0;
        for(int i=1; i*i<=target; i++){
            if(target%i==0) count++;
        }
        return count;
    }
}
