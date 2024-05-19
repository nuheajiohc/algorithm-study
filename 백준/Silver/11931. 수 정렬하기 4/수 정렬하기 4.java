import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr =new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr,(a,b)->b-a);
        StringBuilder sb = new StringBuilder();
        for(int num: arr){
            sb.append(num).append("\n");
        }
        System.out.println(sb.toString());
    }
}
