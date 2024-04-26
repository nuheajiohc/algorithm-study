import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();
            if("enter".equals(action)){
                set.add(name);
            }else{
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
