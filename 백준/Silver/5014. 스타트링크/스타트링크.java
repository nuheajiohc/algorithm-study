import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] d = {U,-D};
        int[] vis = new int[F+1];
        Arrays.fill(vis,-1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(S);
        vis[S]=0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int dir: d){
                int nx = cur+dir;
                if(nx<1 || nx>F) continue;
                if(vis[nx]>-1) continue;
                vis[nx] = vis[cur]+1;
                queue.offer(nx);
            }
        }
        System.out.println(vis[G]>-1?vis[G]:"use the stairs");
    }
}
