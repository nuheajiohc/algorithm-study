import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Bag[] bags = new Bag[N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            bags[i] = new Bag(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        int[][] board = new int[N+1][K+1];
    
        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(j>=bags[i].w) {
                    board[i][j] = Math.max(board[i-1][j], board[i-1][j-bags[i].w]+bags[i].v);
                }else{
                    board[i][j] = board[i-1][j];
                }
            }
        }
        System.out.println(board[N][K]);
    }

    public static class Bag implements Comparable<Bag>{
        int w;
        int v;

        public Bag(int w, int v){
            this.w = w;
            this.v = v;
        }

        public int compareTo(Bag o){
            return o.w-this.w;
        }   
    }
}
