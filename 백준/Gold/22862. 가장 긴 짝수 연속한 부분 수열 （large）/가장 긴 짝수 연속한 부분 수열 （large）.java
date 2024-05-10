import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sequence = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        int maxEven=0;
        int odd=0;
        if(sequence[0]%2==1) odd++;
        int e = 0;
        for(int s=0; s<N; s++){
            while(e < N-1 && odd + sequence[e+1]%2<=K){
                e++;
                odd += sequence[e]%2;
            }
            maxEven = Math.max(maxEven, e-s+1-odd);
            odd -= sequence[s]%2;
        }
        System.out.println(maxEven);

    }
}
