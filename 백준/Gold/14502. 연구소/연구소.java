import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[][] board;
    private static int max;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static List<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==2){
                    virus.add(new int[]{i,j});
                }
            }
        }

        backtracking(0,0);
        System.out.println(max);
    }

    public static void backtracking(int pos, int count){
        if(count==3){
            check();
            return;
        }

        if(pos==N*M){
            return;
        }

        for(int i=pos; i<N*M; i++){
            int x = i/M;
            int y = i%M;
            if(board[x][y]==0){
                board[x][y]=1;
                backtracking(i+1, count+1);
                board[x][y]=0;
            }
        }
    }

    public static void check(){
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][M];
        for(int[] pos : virus){
            q.offer(pos);
            vis[pos[0]][pos[1]] = true;

        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur[0]+dx[dir];
                int ny = cur[1]+dy[dir];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(board[nx][ny]!=0) continue;
                if(vis[nx][ny]) continue;
                vis[nx][ny]=true;
                q.offer(new int[]{nx,ny});
            }
        }

        int count=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!vis[i][j] && board[i][j]!=1){
                    count++;
                }
            }
        }
        max = Math.max(max,count);
    }
}
