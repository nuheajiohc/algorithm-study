import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            int x = Integer.parseInt(st.nextToken());
            for(int j=0; j<N; j++){
                if(arr[j]==0){
                    if(x==0){
                        arr[j]= i+1;
                        break;
                    }else{
                        x--;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0; i<N; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);

    }
}
