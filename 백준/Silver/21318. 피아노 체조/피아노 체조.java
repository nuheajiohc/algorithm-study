import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] levels = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            levels[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] mistakes = new int[N+1];
        for(int i=2; i<=N; i++){
            if(levels[i]>=levels[i-1])mistakes[i]=mistakes[i-1];
            else mistakes[i]=mistakes[i-1]+1;
        }  
        
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(mistakes[y]-mistakes[x]).append("\n");
        }
        System.out.println(sb);
    }
}
