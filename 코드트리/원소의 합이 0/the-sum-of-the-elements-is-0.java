import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  N = Integer.parseInt(br.readLine());

        int[][] arr = new int[4][N];
        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] sum = new int[N*N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sum[i*N + j] = arr[0][i] + arr[1][j];
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int value = arr[2][i] + arr[3][j];
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }

        int count = 0;
        for(int i=0; i<N*N; i++){
            count += map.getOrDefault(-sum[i], 0);
        }

        System.out.println(count);
    }
}