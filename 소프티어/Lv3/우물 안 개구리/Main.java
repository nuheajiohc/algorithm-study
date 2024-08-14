import java.io.*;
import java.util.*;

public class Main {

    private static int n,m;
    private static int[] weight;
    private static List<Integer>[] adj;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        weight = new int[n+1];
        adj = new ArrayList[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            weight[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        int count=0;
        for(int i=1; i<=n; i++){
            if(isBest(i)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isBest(int i){
        for(int other : adj[i]){
            if(weight[i]<=weight[other]){
                return false;
            }
        }
        return true;
    }
}