import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minHeight = Math.max(arr[0]-0, N-arr[M-1]);
        for(int i=1; i<M; i++){
            int value = (int)Math.ceil((arr[i]-arr[i-1])/2.0);
            if(value>minHeight){
                minHeight = value;
            }
        }
        System.out.println(minHeight);
    }
}
