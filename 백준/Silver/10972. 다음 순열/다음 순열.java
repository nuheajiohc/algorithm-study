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

        int idx = N;
        for(int i=N-1; i>0; i--){
            if(arr[i]>arr[i-1]){
                idx = i-1;
                break;
            }
        }

        if(idx==N){
            System.out.println(-1);
            return;
        }

        for(int i=N-1; i>idx; i--){
            if(arr[idx]<arr[i]){
                int temp= arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                break;
            }
        }

        Arrays.sort(arr,idx+1,N);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println((sb.toString()));
    }
}
