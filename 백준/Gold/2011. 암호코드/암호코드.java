import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        int[] dp = new int[code.length()];
        dp[0]=0;
        if(code.charAt(0)-'0'>0){
            dp[0]=1;
        }
        if(code.length()>1){
            if(code.charAt(1)-'0'>0){
                dp[1]=dp[0];
            }
            int num=(code.charAt(0)-'0')*10 + (code.charAt(1)-'0');
            if(num>9 && num<27){
                dp[1]+=1;
            }
        }
        for(int i=2; i<code.length(); i++){
            if(code.charAt(i)-'0'>0){
                dp[i]=dp[i-1]%1000000;
            }
            int num=(code.charAt(i-1)-'0')*10 + (code.charAt(i)-'0');
            if(num>9 && num<27){
                dp[i]=(dp[i]+dp[i-2])%1000000;
            }
        }
        System.out.println(dp[code.length()-1]%1000000);
    }
}
