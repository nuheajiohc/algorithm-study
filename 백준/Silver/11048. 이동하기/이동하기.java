import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                maze[i][j] = Math.max(maze[i-1][j], Math.max(maze[i][j-1], maze[i-1][j-1]));
                maze[i][j] += Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(maze[N][M]);
    }
}
