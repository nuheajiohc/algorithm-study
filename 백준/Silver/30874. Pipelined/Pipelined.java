import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] s = new int[N];
        for(int i=0; i<N; i++){
            s[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(s);
        System.out.println(s[N-1]+N-1);
    }
}