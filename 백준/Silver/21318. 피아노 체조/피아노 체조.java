import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] paper = new int[N+1];
        int[] mistake = new int[N+1];
        for(int i=1; i<=N; i++){
            paper[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<N; i++){
            if(paper[i]>paper[i+1]){
                mistake[i]= mistake[i-1]+1;
            }else{
                mistake[i] = mistake[i-1];
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start<end){
                sb.append(mistake[end-1]-mistake[start-1]).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
