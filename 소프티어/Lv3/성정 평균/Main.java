import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] prefixSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            prefixSum[i] = Integer.parseInt(st.nextToken())+prefixSum[i-1];
        }

        StringBuilder sb = new StringBuilder();
        while(K-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            double avg =(prefixSum[b]-prefixSum[a-1])/(double)(b-a+1);
            
            sb.append(String.format("%.2f",avg)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
