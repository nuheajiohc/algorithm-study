import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] universe = new int[M][N];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                universe[i][j] = Integer.parseInt(st.nextToken());
            }

            int[] uni = Arrays.stream(universe[i]).distinct().sorted().toArray();
            for(int j=0; j<N; j++){
                universe[i][j]=Arrays.binarySearch(uni,universe[i][j]);
            }
        }

        int sum=0;
        for(int i=0; i<M-1; i++){
            for(int j=i+1; j<M; j++){
                if(Arrays.equals(universe[i],universe[j])){
                    sum+=1;
                }
            }
        }
        System.out.println(sum);
    }
}
