import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int rank=1;
        if(N==0){
            System.out.println(rank);
            return;
        }

        int th=1;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int score = Integer.parseInt(st.nextToken());
            if(S<score){
                rank++;
            }else if(S>score){
                break;
            }
            th++;
        }
        if(th>P){
            System.out.println(-1);
        }else{
            System.out.println(rank);
        }

    }
}
