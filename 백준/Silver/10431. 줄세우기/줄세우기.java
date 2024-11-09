import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=p; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[20];
            for(int j=0; j<20; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int count=0;
            for(int j=0; j<20; j++){
                for(int k=0; k<j; k++){
                    if(arr[j]<arr[k]) count++;
                }
            }
            sb.append(t).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
