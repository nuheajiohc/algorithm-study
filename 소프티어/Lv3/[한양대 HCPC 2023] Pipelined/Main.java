import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxValue=0;
        for(int i=0; i<N; i++){
            maxValue = Math.max(maxValue,Integer.parseInt(st.nextToken()));
        }

        System.out.println(maxValue+N-1);
    }
}