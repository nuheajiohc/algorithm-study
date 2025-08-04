import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[][] priority;
    private static boolean[] used;
    private static int maximum = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        priority = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                priority[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        used = new boolean[M];
        check(0,0);
        System.out.println(maximum);
    }

    public static void check(int k, int idx){
        if(idx==3){
            int sum = 0;
            for(int i=0; i<N; i++){
                int value = 0;
                for(int j=0; j<M; j++){
                    if(used[j]){
                        value = Math.max(value, priority[i][j]);
                    }
                }
                sum += value;
            }
            maximum = Math.max(maximum, sum);
            return;
        }

        for(int i=k; i<M; i++){
            
            used[i] = true;
            check(i+1, idx+1);
            used[i] = false;
        }
    }
}
