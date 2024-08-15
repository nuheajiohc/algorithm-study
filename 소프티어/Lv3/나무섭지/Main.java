import java.io.*;
import java.util.*;

public class Main {

    private static int n,m;
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static char[][] board;
    private static int[][] visN, visG;
    private static Queue<int[]> queueN, queueG;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visN = new int[n][m];
        visG = new int[n][m];

        board = new char[n][m];
        queueN = new ArrayDeque<>();
        queueG = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = line.charAt(j);
                if(board[i][j]=='N') {
                    queueN.offer(new int[]{i,j});
                    visN[i][j]=1;
                }
                if(board[i][j]=='G'){
                    queueG.offer(new int[]{i,j});
                    visG[i][j]=1;
                }
            }
        }

        if(moveN() && moveG()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static boolean moveN(){
        while(!queueN.isEmpty()){
            int[] cur=queueN.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur[0]+dx[dir];
                int ny = cur[1]+dy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(visN[nx][ny]>0) continue;
                if(board[nx][ny]=='#' || board[nx][ny]=='G') continue;
                visN[nx][ny] = visN[cur[0]][cur[1]]+1; 
                if(board[nx][ny]=='D'){
                    return true;
                }
                queueN.offer(new int[]{nx,ny});
            }
        }
        return false;
    }

    public static boolean moveG(){
        while(!queueG.isEmpty()){
            int[] cur = queueG.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur[0]+dx[dir];
                int ny = cur[1]+dy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(visG[nx][ny]>0) continue;
                visG[nx][ny] = visG[cur[0]][cur[1]]+1; 
                if(board[nx][ny]=='D' && visG[nx][ny]<=visN[nx][ny]){
                    return false;
                }
                queueG.offer(new int[]{nx,ny});
            }
        }
        return true;    
    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || x>=n || y<0 || y>=m;
    }
}