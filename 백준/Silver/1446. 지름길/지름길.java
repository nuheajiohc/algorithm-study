import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Road> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if(e>D || l >=e-s) continue;
            list.add(new Road(s,e,l));
        }
        
        int[] dp = new int[D+1];
        for(int i=1; i<=D; i++){
            dp[i] = i;
        }   

        for(int i=1; i<=D; i++){
            dp[i] = Math.min(dp[i], dp[i-1] + 1);
            for(Road road : list){
                if(road.end == i){
                    dp[road.end] = Math.min(dp[road.end], dp[road.start]+road.length);
                }
            }
        }
        System.out.println(dp[D]);
    }

    public static class Road{
        int start;
        int end;
        int length;

        Road(int start, int end, int length){
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }
}
