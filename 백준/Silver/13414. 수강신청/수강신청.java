import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Set<String> set = new LinkedHashSet<>();
        for(int i=0; i<L; i++){
            String studentNo = br.readLine();
            if(set.contains(studentNo)){
                set.remove(studentNo);
            }
            set.add(studentNo);
        }

        StringBuilder sb = new StringBuilder();
        for(String stno: set){
            sb.append(stno).append("\n");
            if(--K==0) break;
        }
        System.out.println(sb.toString());
    }
}
