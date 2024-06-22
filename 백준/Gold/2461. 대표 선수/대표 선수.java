import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] students = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                students[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(students[i]);
        }

        int[] indexs = new int[N];
        int minValue=Integer.MAX_VALUE;
        while(true){
            int tempMin = students[0][indexs[0]];
            int tempMax = students[0][indexs[0]];
            int minIdx=0;
            for(int i=1; i<N; i++){
                if(tempMin > students[i][indexs[i]]){
                    tempMin = students[i][indexs[i]];
                    minIdx=i;
                }
                if(tempMax < students[i][indexs[i]]){
                    tempMax = students[i][indexs[i]];
                }
            }
            minValue = Math.min(minValue, tempMax-tempMin);
            indexs[minIdx]++;
            if(indexs[minIdx]>=M) break;
        }
        System.out.println(minValue);
    }
}
