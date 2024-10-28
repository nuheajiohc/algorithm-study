import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(P-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            List<Integer> list = new LinkedList<>();
            list.add(Integer.parseInt(st.nextToken()));
            sb.append(T).append(" ");
            int count=0;
            for(int i=0; i<19; i++){
                int num = Integer.parseInt(st.nextToken());
                for(int j=0; j<list.size(); j++){
                    if(num<list.get(j)){
                        count+=list.size()-j;
                        list.add(j,num);
                        break;
                    }
                }
                if(list.size()==i+1){
                    list.add(num);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
