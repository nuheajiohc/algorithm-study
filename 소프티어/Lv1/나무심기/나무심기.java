import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] F = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            F[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(F);
        System.out.println(Math.max(F[0]*F[1], F[F.length-1]*F[F.length-2]));
    }
}
