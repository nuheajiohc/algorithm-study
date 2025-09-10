import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            Integer[] order = new Integer[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                order[i] = arr[i];
            }
            
            Arrays.sort(order, (a,b)->b-a);

            int order_idx=0;
            int idx=0;
            int th=0;
            while(order_idx<arr.length){
                if(arr[idx]==order[order_idx]){
                    order_idx++;
                    th++;
                    if(idx==M) break;
                }
                idx = (idx+1)%arr.length;
            }
            sb.append(th).append("\n");
        }
        System.out.println(sb);
    }   
}
