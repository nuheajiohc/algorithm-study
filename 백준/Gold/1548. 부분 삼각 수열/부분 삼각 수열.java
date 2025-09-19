import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        if(arr.length<3){
            System.out.println(arr.length);
            return;
        }

        int maximum = 2;
        for(int i=0; i<N; i++){
            for(int j=i+2; j<N; j++){
                if(arr[i]+arr[i+1]>arr[j]){
                    maximum = Math.max(maximum, j-i+1);
                }else{
                    break;
                }
            }    
        }
        System.out.println(maximum);
    }
}
