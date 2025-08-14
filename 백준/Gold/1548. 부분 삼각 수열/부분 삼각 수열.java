import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Math.min(N, 2);

        Arrays.sort(arr);

        int r = 2;
        for(int l=0; l<N; l++){
            if(l+1>=N) break;
            if(r<l+2) r = l+2;

            int sum = arr[l] + arr[l+1];
            while(r<N && sum > arr[r]){
                r++;
            }
        
            ans = Math.max(ans, r-l);

        }
        System.out.println(ans);
    }
}