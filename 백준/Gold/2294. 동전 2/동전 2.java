import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Set<Integer> coins = new HashSet<>();
        for(int i=0; i<n; i++){
            coins.add(Integer.parseInt(br.readLine()));
        }
        List<Integer> uniCoins = new ArrayList<>(coins);
        Collections.sort(uniCoins);

        int[] dp = new int[k+1];
        for(int i=0; i<uniCoins.size(); i++){
            if(uniCoins.get(i)<=k)
                dp[uniCoins.get(i)]=1; 
            for(int j=uniCoins.get(i)+1; j<=k; j++){
                if(dp[j]>0 && dp[j-uniCoins.get(i)]>0)
                    dp[j] = Math.min(dp[j],dp[j-uniCoins.get(i)]+1);
                else if(dp[j]==0 && dp[j-uniCoins.get(i)]>0)
                    dp[j] = dp[j-uniCoins.get(i)]+1;
            }
        }

        if(dp[k]==0){
            System.out.println(-1);
            return;
        }
        System.out.println(dp[k]);
    }
}
