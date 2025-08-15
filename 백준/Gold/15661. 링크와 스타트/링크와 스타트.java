import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] board;
    private static boolean[] used;
    private static int minimum = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        used = new boolean[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        btk(0);
        System.out.println(minimum);
    }

    public static void btk(int k){
        check();
        if(k==N) return;

        used[k] = true;
        btk(k+1);
        used[k] = false;
        btk(k+1);
    }

    public static void check(){
        int start = 0;
        int link = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(used[i] && used[j]){
                    start += board[i][j];
                }
                if(!used[i] && !used[j]){
                    link += board[i][j];
                }
            }
        }

        if(start != 0 && link != 0){
            minimum = Math.min(minimum, Math.abs(start-link));
        }
    }
}
