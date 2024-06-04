import java.io.*;
import java.util.*;

public class Main {

    private static Map<String, Integer> ids = new TreeMap();
    private static String[] names;
    private static List<Integer>[] adj;
    private static List<String>[] relation;
    private static int[] deg;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        relation = new ArrayList[N+1];
        deg = new int[N+1];
        for(int i=0; i<=N; i++){
            adj[i] = new ArrayList<>();
            relation[i] = new ArrayList<>();
        }

        names = new String[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            names[i]=st.nextToken();
            ids.put(names[i],i);
        }

        int M = Integer.parseInt(br.readLine());
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int descendant  = ids.get(st.nextToken());
            int ancestor = ids.get(st.nextToken());
            adj[ancestor].add(descendant);
            deg[descendant]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int ancestorCount = 0;
        List<Integer> ancestorList = new ArrayList<>();
        for(int i=1; i<=N; i++){
            if(deg[i]==0){
                queue.offer(i);
                ancestorCount++;
                ancestorList.add(i);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : adj[cur]){
                deg[next]--;
                if(deg[next]==0){
                    queue.offer(next);
                    relation[cur].add(names[next]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ancestorCount).append("\n");
        for(int ancestor: ancestorList){
            sb.append(names[ancestor]).append(" ");
        }
        sb.append("\n");

        for(Map.Entry<String,Integer> entry: ids.entrySet()){
            String name = entry.getKey();
            Integer id = entry.getValue();
            sb.append(name).append(" ").append(relation[id].size()).append(" ");
            Collections.sort(relation[id]);
            for(String descName : relation[id]){
                sb.append(descName).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static class Relation{
        String ancestor;
        List<String> descendants = new ArrayList<>();
        int deg;
    }
}
