import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = 1;
        int b = N;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(j%2==0){
                    sb.append(a);
                }else{
                    sb.append(b);
                }
            }
            sb.append("\n");
            a++;
            b--;
        }

        System.out.println(sb);
    }
}