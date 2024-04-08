import java.io.*;
import java.util.*;

public class Main {
    private static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] square = new int[N][M];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotate(square,R);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(square[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void rotate(int[][] square, int r){
        Deque<Integer> q = new ArrayDeque<>();
        int t = Math.min(N,M);
        for(int i=0; i<t/2; i++){
            for(int j=i; j<M-i; j++){
                q.offer(square[i][j]);
            }
            for(int j=i+1; j<N-i-1; j++){
                q.offer(square[j][M-i-1]);
            }
            for(int j=M-i-1; j>=i; j--){
                q.offer(square[N-i-1][j]);
            }
            for(int j=N-i-2; j>i; j--){
                q.offer(square[j][i]);
            }

            for(int j=0; j<r; j++){
                q.offer(q.poll());
            }

            for(int j=i; j<M-i; j++){
                square[i][j] = q.poll();
            }
            for(int j=i+1; j<N-i-1; j++){
                square[j][M-i-1]=q.poll();
            }
            for(int j=M-i-1; j>=i; j--){
                square[N-i-1][j] = q.poll();
            }
            for(int j=N-i-2; j>i; j--){
                square[j][i]= q.poll();
            }
        }
    }
}
