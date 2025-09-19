import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N*3+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 0;
        for(int i=1; i<=N; i++){
            arr[i*3] = Math.min(arr[i*3],arr[i]+1);
            arr[i*2] = Math.min(arr[i*2], arr[i]+1);
            arr[i+1] = Math.min(arr[i+1], arr[i]+1);
        }
        System.out.println(arr[N]);
    }
}
