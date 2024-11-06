import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int[] height = new int[N];
        for(int i=1; i<=N; i++){
            int count=0;
            for(int j=0; j<N; j++){
                if(height[j]>0) continue;
                if(count==arr[i-1]){
                    height[j]=i;
                }
                count++;
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(height[i]).append(" ");
        }
        System.out.println(sb);
    }
}
