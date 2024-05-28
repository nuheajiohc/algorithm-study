import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        arr[1][0] = 1;
        arr[1][1] = 1;
        for(int i=2; i<=N; i++){
            arr[i][0] = 1;
            for(int j=1; j<N; j++){
                arr[i][j] = (arr[i-1][j-1]+arr[i-1][j])%10007;
            }
            arr[i][N] = 1;
        }
        System.out.println(arr[N][K]);
    }
}
