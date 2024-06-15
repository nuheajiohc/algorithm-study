import java.io.*;
import java.util.*;

public class Main {

    private static int N,S,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] songs =new int[N];
        for(int i=0; i<N; i++){
            songs[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue= new ArrayDeque<>();
        int[] dp = new int[M+1];
        dp[S]=1;
        for(int i=0; i<N; i++){
            for(int j=0; j<=M; j++){
                if(dp[j]==i+1) queue.offer(j);
            }
            if(queue.isEmpty()) break;
            while(!queue.isEmpty()){
                int cur = queue.poll();
                if(!isOutOfRange(cur-songs[i])) dp[cur-songs[i]]=i+2;
                if(!isOutOfRange(cur+songs[i])) dp[cur+songs[i]]=i+2;
            }
        }
        int answer=-1;
        for(int i=0; i<=M; i++){
            if(dp[i]==N+1) answer=i;
        }
        System.out.println(answer);
    }

    public static boolean isOutOfRange(int x){
        return x<0 || x>M;
    }
}
