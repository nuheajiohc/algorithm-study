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
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        for(int i=0; i<uniCoins.size(); i++){
            for(int j=uniCoins.get(i); j<=k; j++){
                dp[j] = Math.min(dp[j],dp[j-uniCoins.get(i)]+1);
            }
        }
        System.out.println(dp[k]==Integer.MAX_VALUE-1?-1:dp[k]);
    }
}
