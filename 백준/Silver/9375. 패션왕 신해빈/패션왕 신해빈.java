import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            Map<String, List<String>> map = new HashMap<>();
            while(N-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String category = st.nextToken();
                map.computeIfAbsent(category, k-> new ArrayList<>()).add(item);
            }
            int count=1;
            for(List<String> items : map.values()){
                count*=items.size()+1;
            }
            sb.append(count-1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
