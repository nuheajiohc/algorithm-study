import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K+1];
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if(W>K) continue;
            for(int i=K; i>=W; i--){
                arr[i] = Math.max(arr[i], V + arr[i-W]);
            }
        }
        
        int max = 0;
        for(int i=0; i<=K; i++){
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }
}
