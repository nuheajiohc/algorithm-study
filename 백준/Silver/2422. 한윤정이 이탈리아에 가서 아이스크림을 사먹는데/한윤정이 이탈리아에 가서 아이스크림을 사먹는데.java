import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] block = new boolean[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a<b){
                block[a][b] = true;
            }else{
                block[b][a] = true;
            }
        }

        int count = 0;
        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                for(int k=j+1; k<=N; k++){
                    if(!(block[i][j] || block[i][k] || block[j][k])){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
