import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        while(N-->0){
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        while(M-->0){
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()){
                set.remove(st.nextToken());
            }

            sb.append(set.size()).append("\n");
        }

        System.out.println(sb);
        
    }
}
