import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int idx=1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if(L==0 && P==0 && V==0) break;
            int day = (V/P)*L + (V%P>L?L:V%P);
            sb.append("Case ").append(idx).append(": ").append(day).append("\n");
            idx++;
        }
        System.out.println(sb.toString());
    }
}
