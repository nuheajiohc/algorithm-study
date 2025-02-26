import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int count=0;
        
        for(int t=0; t<N; t++){
            int l = 0;
            int r = N-1;
            while(l<r){
                if(l == t){
                    l++;
                    continue;
                }
                if(r==t){
                    r--;
                    continue;
                }
                if(arr[l]+arr[r]<arr[t]){
                    l++;
                }else if(arr[l]+arr[r]>arr[t]){
                    r--;
                }else{
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    } 
}
