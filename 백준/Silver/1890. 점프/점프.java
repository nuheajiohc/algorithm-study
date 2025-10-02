import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] board;
    private static long[][] route;
    private static int[] dx = {0, 1};
    private static int[] dy = {1, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        route = new long[N][N];
        route[0][0] = 1;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(route[i][j]==0) continue;
                if(i==N-1 && j==N-1) break;
                for(int dir=0; dir<2; dir++){
                    int nx = i+board[i][j]*dx[dir];
                    int ny = j+board[i][j]*dy[dir];
                    if(nx >= N || ny >= N) continue;
                    route[nx][ny] += route[i][j];
                }
            }
        }

        System.out.println(route[N-1][N-1]);
    }
}
