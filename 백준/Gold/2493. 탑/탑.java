import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] top = new int[N+1];
        int[] ans = new int[N+1];
        ans[1] = 0;
        for(int i=1; i<=N; i++){
            top[i]= Integer.parseInt(st.nextToken());
        }

        for(int i=2; i<=N; i++){
            int j=i-1;
            while(j>0){
                if(top[i]<=top[j]){
                    ans[i] = j;
                    break;
                }else{
                    j=ans[j];
                }
            }
        }

        for(int i=1;i<=N; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());
    }   
}
