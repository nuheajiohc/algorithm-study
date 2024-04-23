import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[][] board;
    private static int[][][] vis;
    private static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        vis = new int[N][M][2];
        for(int k=0; k<2; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    vis[i][j][k]=-1;
                }
            }
        }
        vis[0][0][0]=1;

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j] = s.charAt(j)-'0';
            }
        }
        bfs();
    }

    public static void bfs(){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(cur[0]==N-1 && cur[1]==M-1){
                System.out.println(vis[cur[0]][cur[1]][cur[2]]);
                return;
            }

            for(int[] dir : d){
                int nx=cur[0]+dir[0];
                int ny=cur[1]+dir[1];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(board[nx][ny]==1 && cur[2]==1) continue;

                int state = board[nx][ny] | cur[2];
                if(vis[nx][ny][state]!=-1) continue;
                vis[nx][ny][state] = vis[cur[0]][cur[1]][cur[2]]+1;
                q.offer(new int[]{nx,ny,state});
            }
        }
        System.out.println(-1);
    }
}
