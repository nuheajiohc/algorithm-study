import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int d = r-l;
            
            double raw = Math.sqrt(d);
            int min = (int)Math.floor(raw);
            if(d <= min*min){
                sb.append(min*2-1).append("\n");
            }else if(d<=min*min+min){
                sb.append(min*2).append("\n");
            }else{
                sb.append(min*2+1).append("\n");
            }

        }
        System.out.println(sb);
    }
}
