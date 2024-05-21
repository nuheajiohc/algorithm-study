import java.io.*;
import java.util.*;

public class Main {

    private static int[] mDx = {0,1,-1,0};
    private static int[] mDy = {1,0,0,-1};
    private static int[] hDx = {1,1,2,2,-1,-1,-2,-2};
    private static int[] hDy = {2,-2,1,-1,2,-2,1,-1};
    private static int[][] board;
    private static int[][][] vis;
    private static int H,W,K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        int answer=Integer.MAX_VALUE;
        for(int i=0; i<=K; i++){
            if(vis[H-1][W-1][i]==0) continue;
            if(answer>vis[H-1][W-1][i]){
                answer = vis[H-1][W-1][i];
            }
        }

        System.out.println(answer==Integer.MAX_VALUE?-1:answer-1);

    }

    public static void bfs(){
        vis = new int[H][W][K+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,0});
        if(board[0][0]==1) return;
        vis[0][0][0]=1;
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            int nk = cur[2];
            for(int dir=0; dir<4; dir++){
                int nx = cur[0]+mDx[dir];
                int ny = cur[1]+mDy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(vis[nx][ny][nk]>0 || board[nx][ny]==1) continue;
                vis[nx][ny][nk] = vis[cur[0]][cur[1]][cur[2]]+1;
                queue.offer(new int[]{nx,ny,nk});
            }

            if(nk>=K) continue;
            for(int dir=0; dir<8; dir++){
                int nx = cur[0]+hDx[dir];
                int ny = cur[1]+hDy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(vis[nx][ny][nk+1]>0 || board[nx][ny]==1) continue;
                vis[nx][ny][nk+1] = vis[cur[0]][cur[1]][cur[2]]+1;
                queue.offer(new int[]{nx,ny,nk+1});
            }
        }
    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || x>=H || y<0 || y>=W;
    }
}
