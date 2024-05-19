import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static List<Integer>[] adj;
    private static int[] deg;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        deg = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        while(M-->0){
            String[] line = br.readLine().split(" ");
            int singersSum = Integer.parseInt(line[0]);
            for(int i=2; i<=singersSum; i++){
                int a = Integer.parseInt(line[i-1]);
                int b = Integer.parseInt(line[i]);
                adj[a].add(b);
                deg[b]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            if(deg[i]==0) queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(deg[cur]==0) sb.append(cur).append("\n");

            for(int next: adj[cur]){
                deg[next]--;
                if(deg[next]==0) queue.offer(next);
            }
        }

        for(int i=1; i<N; i++){
            if(deg[i]>0){
                System.out.println(0);
                return;
            }
        }
        System.out.println(sb.toString());
    }
}
