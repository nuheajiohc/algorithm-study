import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static double[][] stars;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stars = new double[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new double[]{x, y};
        }

        double minWeight = prim(0);
        System.out.printf("%.2f" ,minWeight);
    }

    static double prim(int start){
        boolean[] visited = new boolean[N];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        double minWeight = 0;
        int connected = 0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(visited[now.to]) continue;
            visited[now.to] = true;
            minWeight += Math.sqrt(now.weight);
            connected++;
            
            if(connected == N) break;

            for(int i=0; i<N; i++){
                if(visited[i]) continue;
                double xSquare = (stars[now.to][0]-stars[i][0])*(stars[now.to][0]-stars[i][0]);
                double ySquare = (stars[now.to][1]-stars[i][1])*(stars[now.to][1]-stars[i][1]);
                double wSquare = xSquare + ySquare;
                pq.offer(new Edge(i, wSquare));
            }
        }

        return minWeight;
    }

    static class Edge implements Comparable<Edge>{
        int to;
        double weight;

        Edge(int to, double weight){
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge o){
            return Double.compare(this.weight, o.weight);
        }
    }
}
