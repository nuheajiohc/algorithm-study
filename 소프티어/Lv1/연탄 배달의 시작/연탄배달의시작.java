import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] position = new int[N];
        for(int i=0; i<N; i++){
            position[i] = Integer.parseInt(st.nextToken());
        }

        int minDistance= Integer.MAX_VALUE;
        int count=0;
        for(int i=0; i<N-1; i++){
            if(minDistance > position[i+1]-position[i]){
                count=1;
                minDistance = position[i+1]-position[i];
            }else if(minDistance == position[i+1]-position[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}
