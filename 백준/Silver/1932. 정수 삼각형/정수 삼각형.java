import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+2];

        for(int i=1; i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++){
                arr[i][j] = Integer.parseInt(st.nextToken())+ Math.max(arr[i-1][j-1], arr[i-1][j]);
            }
        }

        int result=0;
        for(int i=1; i<=n;i++){
            result = Math.max(result,arr[n][i]);
        }
        System.out.println(result);
    }    
}
