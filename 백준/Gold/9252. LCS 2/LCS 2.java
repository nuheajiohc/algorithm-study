import java.io.*;
import java.util.*;

public class Main {

    private static int maxValue;
    private static int[][] dp;
    private static String ss1,ss2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ss1 = br.readLine();
        ss2 = br.readLine();

        dp = new int[ss1.length()+1][ss2.length()+1];

        maxValue = 0;
        for(int i=1; i<=ss1.length(); i++){
            for(int j=1; j<=ss2.length(); j++){
                if(ss1.charAt(i-1) == ss2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                maxValue = Math.max(dp[i][j],maxValue);
            }
        }
        System.out.println(maxValue);
        if(maxValue!=0){
            int count = maxValue-1;
            int x=ss1.length();
            int y=ss2.length();
            char[] arr = new char[maxValue];
            while(x>0 && y>0){
                if(ss1.charAt(x-1)==ss2.charAt(y-1)){
                    arr[count] = ss1.charAt(x-1);
                    count--;
                    x--;
                    y--;
                }else if(dp[x][y] == dp[x-1][y]){
                    x--;
                }else{
                    y--;
                }
            }
            System.out.println(String.valueOf(arr));
        }
    }
}
