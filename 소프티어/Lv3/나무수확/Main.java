import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n+1][n+1];
        int[][] sum = new int[n+1][n+1];
        int[][] answer = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                sum[i][j] = Math.max(sum[i-1][j],sum[i][j-1])+grid[i][j];
                answer[i][j] = sum[i][j]+grid[i][j];
                int temp = Math.max(answer[i-1][j],answer[i][j-1])+grid[i][j];
                answer[i][j] = Math.max(temp, answer[i][j]);
            }
        }
        System.out.println(answer[n][n]);
    }
}
