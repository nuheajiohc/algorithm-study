import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] board;
    private static boolean[][] vis;
    private static int minimum = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        vis = new boolean[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0);
        System.out.println(minimum);
    }

    public static void recur(int count, int sum){
        if(count==3){
            minimum = Math.min(minimum, sum);
            return;
        }

        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                if(impossible(i,j)) continue;
                vis[i][j]=true;
                vis[i+1][j]=true;
                vis[i-1][j]=true;
                vis[i][j+1]=true;
                vis[i][j-1]=true;
                recur(count+1, sum + check(i, j));
                vis[i][j]=false;
                vis[i+1][j]=false;
                vis[i-1][j]=false;
                vis[i][j+1]=false;
                vis[i][j-1]=false;
            }
        }
    }

    public static boolean impossible(int x, int y){
        if(vis[x][y] || vis[x+1][y] || vis[x-1][y] || vis[x][y-1] || vis[x][y+1]){
            return true;
        }
        return false;
    }

    public static int check(int x, int y){
        int sum = 0;
        sum = board[x][y];
        sum += board[x+1][y];
        sum += board[x-1][y];
        sum += board[x][y-1];
        sum += board[x][y+1];
        return sum;
    }
}
