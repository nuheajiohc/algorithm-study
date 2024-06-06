import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static List<Point>[][] adj;
    private static int[][] board;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board= new int[N+1][N+1];
        adj = new ArrayList[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                adj[i][j] = new ArrayList<>();
            }
        }

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[x][y].add(new Point(a,b));
        }

        int count=1;
        Queue<Point> move = new ArrayDeque<>();
        move.offer(new Point(1,1));
        board[1][1]=2;
        while(!move.isEmpty()){
            Point cur = move.poll();
            for(Point next: adj[cur.x][cur.y]){
                if(board[next.x][next.y]==0){
                    board[next.x][next.y]=1;
                    count++;
                }
            }

            for(int dir=0; dir<4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(board[nx][ny]==1){
                    board[nx][ny]=2;
                    move.offer(new Point(nx,ny));
                }
            }

            if(move.isEmpty()){
                for(int i=1; i<=N; i++){
                    for(int j=1; j<=N; j++){
                        if(board[i][j]==1){
                            for(int dir=0; dir<4; dir++){
                                int nx = i+dx[dir];
                                int ny = j+dy[dir];
                                if(isOutOfRange(nx,ny)) continue;
                                if(board[nx][ny]==2){
                                    move.offer(new Point(i,j));
                                    board[i][j]=2;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

    public static boolean isOutOfRange(int x, int y){
        return x<1 || x>N || y<1 || y>N;
    }

    public static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
