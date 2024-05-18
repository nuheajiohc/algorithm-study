import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        int caseNum=0;
        while(true){
            caseNum++;
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;

            int[][] graph = new int[N][5];
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(graph[0],Integer.MAX_VALUE);
            st.nextToken();
            graph[0][2] = Integer.parseInt(st.nextToken());
            graph[0][3] = Integer.parseInt(st.nextToken())+graph[0][2];
            for(int i=1; i<N; i++){
                st = new StringTokenizer(br.readLine());
                graph[i][0] = Integer.MAX_VALUE;
                graph[i][4] = Integer.MAX_VALUE;
                for(int j=1; j<4; j++){
                    graph[i][j] = Math.min(graph[i-1][j-1],graph[i-1][j]);
                    graph[i][j] = Math.min(graph[i][j], graph[i-1][j+1]);
                    graph[i][j] = Math.min(graph[i][j], graph[i][j-1]);
                    graph[i][j] += Integer.parseInt(st.nextToken());
                }
            }
            sb.append(caseNum).append(". ").append(graph[N-1][2]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
