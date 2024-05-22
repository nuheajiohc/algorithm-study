import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static char[][] board = new char[12][6];
    private static boolean[][] vis;
    private static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<12; i++){
            String line = br.readLine();
            for(int j=0; j<line.length(); j++){
                board[i][j]= line.charAt(j);
            }
        }
        int result=0;
        while(removePuyo()){
            downPuyo();
            result++;
        }
        System.out.println(result);

    }


    public static void downPuyo(){
        for(int i=0; i<6; i++){
            Queue<Character> queue = new ArrayDeque<>();
            for(int j=11; j>=0; j--){
                if(board[j][i]!='.') queue.offer(board[j][i]);
            }

            for(int j=11; j>=0; j--){
                if(!queue.isEmpty()){
                    board[j][i]=queue.poll();
                }else{
                    board[j][i]='.';
                }
            }
            
        }
    }

    public static boolean removePuyo(){
        vis = new boolean[12][6];
        boolean canRemove = false;
        for(int i=0; i<12; i++){
            for(int j=0; j<6; j++){
                if(vis[i][j] || board[i][j]=='.') continue;
                char curPuyo = board[i][j];
                count=1;
                bfs(curPuyo,i,j);
                if(count>=4) canRemove =true;
            }
        }
        return canRemove;
    }

    public static void bfs(int curPuyo, int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y});
        vis[x][y] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur[0]+dx[dir];
                int ny = cur[1]+dy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(vis[nx][ny]) continue;
                if(board[nx][ny]!=curPuyo) continue;
                vis[nx][ny] = true;
                queue.offer(new int[]{nx,ny});
                count++;
            }
        }

        if(count>=4){
            queue.offer(new int[]{x,y});
            while(!queue.isEmpty()){
                int[] cur= queue.poll();
                for(int dir=0; dir<4; dir++){
                    int nx = cur[0]+dx[dir];
                int ny = cur[1]+dy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(board[nx][ny]!=curPuyo) continue;
                queue.offer(new int[]{nx,ny});
                board[nx][ny]='.';
                }
            }
        }
    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || x>=12 || y<0 || y>=6;
    }
}
