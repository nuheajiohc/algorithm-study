import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ansL=arr[0];
        int ansR=arr[N-1];

        int s = 0; 
        int e = N-1;
        while(s+1<e){
            if(arr[s]+arr[e]<0){
                s++;
            }else if(arr[s]+arr[e]>0){
                e--;
            }else{
                ansL = arr[s];
                ansR = arr[e];
                break;
            }
            
            if(Math.abs(ansL+ansR) > Math.abs(arr[s]+arr[e])){
                ansL = arr[s];
                ansR = arr[e];
            }
        }

        System.out.println(ansL + " " + ansR);
    }
}
