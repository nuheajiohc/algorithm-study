import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] min = new int[N];
        min[0] = arr[0];
        for(int i=1; i<N; i++){
            min[i] = Math.min(min[i-1], arr[i]);
        }

        int[] max = new int[N];
        max[N-1] = arr[N-1];
        for(int i=N-2; i>=0; i--){
            max[i] = Math.max(max[i+1], arr[i]);
        }

        int result = 0;
        for(int i=0; i<N; i++){
            result = Math.max(result, max[i]-min[i]);
        }
        System.out.println(result);
    }
}