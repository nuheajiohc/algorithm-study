import java.io.*;
import java.util.*;

public class Main {
    private static int[] dx = {1,0,0,-1};
    private static int[] dy = {0,1,-1,0};
    private static int[][] board;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T;i++){
            int count=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            board = new int[N][M];
            for (int a = 0 ; a < K; a++){
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    board[y][x] = 1;
            }

            for(int a=0; a<N; a++){
                for(int b=0; b<M; b++){
                    if(board[a][b]!=1){
                        continue;
                    }
                    count++;
                    Deque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{a,b});
                    board[a][b]=2;
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        for(int dir=0; dir<4 ;dir++){
                            int nx=cur[0]+dx[dir];
                            int ny=cur[1]+dy[dir];
                            if(nx<0 || ny<0 || nx>=N || ny>=M){
                                continue;
                            }

                            if(board[nx][ny]!=1){
                                continue;
                            }
                            board[nx][ny]=2;
                            q.offer(new int[] {nx,ny});
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        } 
        System.out.println(sb.toString());
    }
}
