import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        int[] dp=new int[N+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        int answer=1;
        int prev=0;
        for(int i=0; i<M; i++){
            int cur=Integer.parseInt(br.readLine());
            answer*=dp[cur-prev-1];
            prev=cur;
        }
        answer*=dp[N-prev];
        System.out.println(answer);
    }
}