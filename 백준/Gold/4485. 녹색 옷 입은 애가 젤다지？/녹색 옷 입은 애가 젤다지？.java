import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0,0, 1, -1}, dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int tc=1;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            int[][] board = new int[N][N];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] d = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    d[i][j] = Integer.MAX_VALUE;
                }
            }
            PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.e-b.e);

            d[0][0] = board[0][0];
            pq.add(new Node(0,0,0));
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                if(d[cur.x][cur.y] < cur.e) continue;
                for(int dir=0; dir<4; dir++){
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                    if(d[nx][ny] <= d[cur.x][cur.y]+board[nx][ny]) continue;
                    d[nx][ny] = d[cur.x][cur.y] + board[nx][ny];
                    pq.offer(new Node(nx, ny, d[nx][ny]));
                }
            }

            sb.append("Problem ").append(tc).append(": ").append(d[N-1][N-1]).append("\n");
            tc++;
        }

        System.out.println(sb);
    }

    static class Node{
        int x;
        int y;
        int e;

        Node(int x, int y, int e){
            this.x = x;
            this.y = y;
            this.e = e;
        }
    }
}
