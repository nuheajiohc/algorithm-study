import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static List<Integer>[] adj;
    private static boolean[] used;
    private static boolean possible;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        for(int i=0; i<N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i=0; i<N && !possible; i++){
            used = new boolean[N];
            used[i] = true;
            btk(i, 1);
        }

        if(possible){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

    public static void btk(int cur, int count){
        if(possible) return;
        if(count==5){
            possible =true;
            return;
        }

        for(int next : adj[cur]){
            if(used[next]) continue;
            used[next] = true;
            btk(next, count+1);
            used[next] = false;
        }
    }
}
