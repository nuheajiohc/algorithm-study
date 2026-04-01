import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[1001];

        while(st.hasMoreTokens()){
            int value = Integer.parseInt(st.nextToken());
            arr[value]++;
        }

        int max = -1;
        for(int i=1; i<=1000; i++){
            if(arr[i]==0 && max < arr[i]){
                max = i;
            }
        }
        System.out.println(max);
    }
}