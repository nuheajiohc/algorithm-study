import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] pocketmons = new String[N+1];
        Map<String, Integer> map = new HashMap<>();

        for(int i=1; i<=N; i++){
            pocketmons[i] = br.readLine();
            map.put(pocketmons[i],i);
        }
        for(int i=0;i<M;i++){
            String input = br.readLine();
            if(input.charAt(0)-'A'>=0){
                sb.append(map.get(input));
            }else{
                sb.append(pocketmons[Integer.parseInt(input)]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
