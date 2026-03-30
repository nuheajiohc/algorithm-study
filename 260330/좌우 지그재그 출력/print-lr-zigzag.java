import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i%2==1){
                    sb.append(j + (i-1)*N).append(" ");
                }else{
                    sb.append((i*N) - j + 1).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}