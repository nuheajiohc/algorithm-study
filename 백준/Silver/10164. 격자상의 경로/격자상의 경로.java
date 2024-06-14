import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int kx = (K-1)/M;
        int ky = (K%M)==0 ? M-1 : (K%M)-1;

        int[][] board = new int[N][M];
        Arrays.fill(board[0],1);

        for(int i=1; i<N; i++){
            board[i][0] = 1;
            for(int j=1; j<M; j++){
                board[i][j] = board[i-1][j]+board[i][j-1];
            }
        }

        if(K==0){
            System.out.println(board[N-1][M-1]);
        }else{
            System.out.println(board[kx][ky]*board[N-1-kx][M-1-ky]);
        }

    }
}
