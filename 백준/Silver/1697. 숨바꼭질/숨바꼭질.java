import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] vis = new int[100001];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(N);
        vis[N]=1;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur*2<100001 &&vis[cur*2]==0){
                vis[cur*2]= vis[cur]+1;
                q.offer(cur*2);
            }

            if(cur+1<100001 && vis[cur+1]==0){
                vis[cur+1] = vis[cur]+1;
                q.offer(cur+1);
            }

            if(cur-1>=0 && vis[cur-1]==0){
                vis[cur-1] =vis[cur]+1;
                q.offer(cur-1);
            }
        }
        System.out.println(vis[K]-1);
    }   
}
