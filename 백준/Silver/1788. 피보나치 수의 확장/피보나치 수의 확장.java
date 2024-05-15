import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int positiveN = Math.abs(N);
        int[] dp = new int[positiveN+1];
        if(positiveN>0){
            dp[1]=1;
        }
        for(int i=2; i<=positiveN; i++){
            dp[i] = (dp[i-1]+dp[i-2])%1_000_000_000;
        }

        if(N<0 && N%2==0){
            System.out.println(-1);
        }else if(N==0){
            System.out.println(0);
        }else{
            System.out.println(1);
        }
        System.out.println(dp[positiveN]);

    }
}
