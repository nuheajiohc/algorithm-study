import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];
        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a]=b;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        int[] vis = new int[101];
        Arrays.fill(vis, -1);
        vis[1]=0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=1; i<7; i++){
                int next = cur+i;
                if(next>100) continue;
                if(vis[next]>-1) continue;
                if(arr[next]>0){
                    if(vis[arr[next]]==-1){
                        vis[arr[next]]=vis[cur]+1;
                        q.offer(arr[next]);
                    }
                }else{
                    vis[next] = vis[cur]+1;
                    q.offer(next);
                }
            }
        }
        System.out.println(vis[100]);
    }
}

