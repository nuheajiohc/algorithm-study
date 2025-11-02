import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitors = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        int cur = 0;
        int max = 0;
        int count = 1;

        for(int i=0; i<X; i++){
            cur += visitors[i];
        }
        max = cur;

        for(int i=X; i<N; i++){
            cur += visitors[i];
            cur -= visitors[i-X];

            if(max < cur){
                max = cur;
                count = 1;
            }else if(max == cur){
                count++;
            }
            
        }

        if(max==0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(count);
        }

    }
}
