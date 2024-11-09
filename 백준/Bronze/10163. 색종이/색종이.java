import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] paper = new int[1001][1001];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            for(int j=y; j<y+h; j++){
                for(int k=x; k<x+w; k++){
                    paper[j][k] = i;
                }
            }
        }

        int[] arr = new int[N+1];
        for(int i=0; i<1001; i++){
            for(int j=0; j<1001; j++){
                arr[paper[i][j]]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
