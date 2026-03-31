import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==1 || (j>=i && j%2==0)){
                    sb.append("* ");
                }else{
                    sb.append("  ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}