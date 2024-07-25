import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,wrecker;
    private static int[][] board;

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
                if(board[i][j]==1) wrecker++;
            }
        }

        for(int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            removeWrecker(L,R);
        }
        System.out.println(wrecker);
    }

    public static void removeWrecker(int l, int r){
        for(int i=l-1; i<r; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]==1){
                    board[i][j]=0;
                    wrecker--;
                    break;
                }
            }
        }
    }
}
