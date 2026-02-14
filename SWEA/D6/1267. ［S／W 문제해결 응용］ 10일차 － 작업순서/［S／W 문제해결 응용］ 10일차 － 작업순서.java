import java.io.*;
import java.util.*;

public class Solution {

    static int V,E;
    static List<Integer>[] adj;
    static boolean[] used; 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            List<Integer> answer = new ArrayList<>();
            adj = new ArrayList[V+1];
            for(int i=1; i<=V; i++) adj[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
            }

            used = new boolean[V+1];

            int cnt = 0;
            while(cnt<V){
                for(int i=1; i<=V; i++){
                    if(used[i]) continue;
                    if(!hasSubNode(i)){
                        used[i] = true;
                        answer.add(i);
                        cnt++;
                    }
                }
            }
            

            sb.append("#").append(tc).append(" ");
            for(int i=V-1; i>=0; i--){
                sb.append(answer.get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean hasSubNode(int v){
        int cnt =0;
        for(int u : adj[v]){
            if(used[u]) continue;
            cnt++;
        }
        return cnt>0;
    }
}
