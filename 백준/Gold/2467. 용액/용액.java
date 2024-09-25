import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] values = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            values[i] = Integer.parseInt(st.nextToken());
        }

        int minSum = Integer.MAX_VALUE;
        int minValue=0;
        int maxValue=0;
        for(int i=0; i<N-1; i++){
            int s = i;
            int e = N;
            while(s+1<e){
                int mid = (s+e)/2;
                if(values[i]+values[mid]<=0) s=mid;
                else e=mid;

                if(minSum>Math.abs(values[i]+values[mid])){
                    minValue = values[i];
                    maxValue = values[mid];
                    minSum = Math.abs(values[i]+values[mid]);
                }
            }
        }
        System.out.println(minValue + " " + maxValue);

    }
}
