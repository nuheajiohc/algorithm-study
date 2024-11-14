import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[W];
        for(int i = 0; i < W; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] left = new int[W];
        left[0] = arr[0];
        for(int i = 1; i < W; i++){
            left[i] = Math.max(left[i-1], arr[i]);
        }

        int[] right = new int[W];
        right[W-1] = arr[W-1];
        for(int i = W-2; i >= 0; i--){
            right[i] = Math.max(right[i+1], arr[i]);
        }

        int max=0;
        for(int i=1; i < W-1; i++){
            int min = Math.min(left[i],right[i]);
            if(min>arr[i]) max+= min-arr[i];
        }
        System.out.println(max);
    }
}
