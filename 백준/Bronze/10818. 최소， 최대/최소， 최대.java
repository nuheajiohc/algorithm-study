import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = 1_000_000;
        int max = -1_000_000;
        for(int value : arr){
            min = Math.min(value, min);
            max = Math.max(value, max);
        }
        System.out.println(min+" "+max);
    }
}
