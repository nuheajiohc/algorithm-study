import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max=0;
            long result=0;
            for(int i=N-1; i>=0; i--){
                if(max<arr[i]){
                    max=arr[i];
                }else if(max>arr[i]){
                    result+=max-arr[i];
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
