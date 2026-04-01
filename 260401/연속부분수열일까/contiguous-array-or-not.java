import java.io.*;
import java.util.*;

public class Main {

    static int N1, N2;
    static int[] A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());

        A = new int[N1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N1; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        B = new int[N2];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N2; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        if(N1<N2){
            System.out.println("No");
        }else{
            String answer = check();
            System.out.println(answer);
        }
    }

    static String check(){
        for(int i=0; i<=N1-N2; i++){
            int same = 0;
            for(int j=0; j<N2; j++){
                if(A[i+j]==B[j]){
                    same++;
                }
            }
            if(same == N2) return "Yes";
        }
        return "No";
    }
}