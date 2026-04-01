import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N-1; i>=0; i--){
            int idx = nums[i];
            arr[idx] = i+1;
        }

        StringBuilder sb = new StringBuilder();
        int right = N+1;
        for(int i=1000; i>=0; i--){
            if(arr[i]==0) continue;
            if(right>arr[i]){
                sb.append(arr[i]).append(" ");
                right = arr[i];
            }
        }
        System.out.println(sb);

    }
}