import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] mistakes = new int[N+1];
        for(int i=1; i<N; i++){
            if(nums[i]>nums[i+1]) mistakes[i+1] = mistakes[i]+1;
            else mistakes[i+1]=mistakes[i];
        }
        
        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(mistakes[b]-mistakes[a]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
