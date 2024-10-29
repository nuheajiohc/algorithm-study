import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            if(gender==1){
                for(int i=pos; i<=N; i+=pos){
                    arr[i] = (arr[i]+1)%2;
                }
            }else{
                arr[pos] = (arr[pos]+1)%2;
                int temp=1;
                while(pos+temp<=N && pos-temp>0 && arr[pos+temp]==arr[pos-temp]){
                    arr[pos+temp] = (arr[pos+temp]+1)%2;
                    arr[pos-temp] = (arr[pos-temp]+1)%2;
                    temp++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(arr[i]).append(" ");
            if(i%20==0) sb.append("\n");
        }
        System.out.println(sb);
    }
}
