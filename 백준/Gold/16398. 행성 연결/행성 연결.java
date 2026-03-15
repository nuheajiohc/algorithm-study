import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long minWeight = prim(0);
        System.out.println(minWeight);
    }

    static long prim(int start){
        boolean[] visited = new boolean[N+1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.offer(new int[]{start, 0});
        long minWeight = 0;
        int connected = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int v = cur[0];
            int w = cur[1]; 

            if(visited[v]) continue;
            visited[v] = true;
            minWeight += w;
            connected++;

            if(connected==N) break;

            for(int i=0; i<N; i++){
                if(visited[i]) continue;
                pq.offer(new int[]{i, board[v][i]});
            }
        }
        return minWeight;
    }
}
