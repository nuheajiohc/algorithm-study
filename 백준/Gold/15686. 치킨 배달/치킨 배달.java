import java.io.*;
import java.util.*;

public class Main {

    static int N,M, houseLen, chickenLen;
    static boolean[] used;
    static int[] house = new int[100];
    static int[] chicken = new int[13];
    static int[][] dist;
    static int minSum = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[2*N][13];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num==1){
                    house[houseLen++] = i*N+j;
                }else if(num==2){
                    chicken[chickenLen++] = i*N+j;;
                }
            }
        }

        for(int i=0; i<houseLen; i++){
            for(int j=0; j<chickenLen; j++){
                int hx = house[i]/N;
                int hy = house[i]%N;
                int cx = chicken[j]/N;
                int cy = chicken[j]%N;
                dist[i][j] = Math.abs(hx-cx) + Math.abs(hy-cy);
            }
        }

        used = new boolean[chickenLen];
        subset(0, 0);

        System.out.println(minSum);
    }

    static void subset(int depth, int k){
        if(depth == M){
            findMinSum();
            return;
        }

        for(int i=k; i<chickenLen; i++){
            used[i] = true;
            subset(depth+1, i+1);
            used[i] = false;
        }
    }

    static void findMinSum(){
        int sum = 0;
        for(int i=0; i<houseLen; i++){
            int tmp = Integer.MAX_VALUE;
            for(int j=0; j<chickenLen; j++){
                if(!used[j]) continue;
                tmp = Math.min(tmp, dist[i][j]);
            }
            sum += tmp;
        }

        minSum = Math.min(minSum, sum);
    }
}
