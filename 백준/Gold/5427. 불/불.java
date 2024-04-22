import java.io.*;
import java.util.*;

public class Main {

    private static int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
    
            Deque<Position> q = new ArrayDeque<>();
            char[][] board = new char[h][w];
            for(int j=0; j<h; j++){
                String s = br.readLine();
                for(int k=0; k<w; k++){
                    board[j][k] = s.charAt(k);
                    if(board[j][k]=='*'){
                        q.offerLast(new Position(j,k,1));
                    }
                    if(board[j][k]=='@'){
                        q.offerFirst(new Position(j,k,1));
                    }
                }
            }
            bfs(board,w,h,q);
        }
        System.out.println(sb.toString());
    }

    public static void bfs(char[][] board, int w, int h, Deque<Position> q){
        while(!q.isEmpty()){
            Position cur=q.poll();
            if((cur.i==0 || cur.i==h-1 || cur.j==0 || cur.j==w-1) && board[cur.i][cur.j]=='@'){
                sb.append(cur.count).append("\n");
                return;
            }
            for(int[] dir : d){
                int nx = cur.i + dir[0];
                int ny = cur.j + dir[1];
    
                if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
                if(board[nx][ny]=='.' || (board[nx][ny]=='@' && board[cur.i][cur.j]=='*')){
                    board[nx][ny]=board[cur.i][cur.j];
                    q.offer(new Position(nx,ny,cur.count+1));
                }
            }
        }
        sb.append("IMPOSSIBLE").append("\n");
    }

    static class Position{
        int i;
        int j;
        int count;

        public Position(int i, int j, int count){
            this.i = i;
            this.j=j;
            this.count=count;
        }
    }
}
