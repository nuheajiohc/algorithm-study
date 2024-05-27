import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String[]> groupMap = new HashMap<>();
        Map<String,String> memberMap = new HashMap<>();
        while(N-->0){
            String groupName = br.readLine();
            int count = Integer.parseInt(br.readLine());
            String[] members = new String[count];
            for(int i=0; i<count; i++){
                members[i] = br.readLine();
                memberMap.put(members[i],groupName);
            }
            Arrays.sort(members);
            groupMap.put(groupName,members);
        }

        StringBuilder sb = new StringBuilder();
        while(M-->0){
            String str = br.readLine();
            int command = Integer.parseInt(br.readLine());
            if(command==1){
                sb.append(memberMap.get(str)).append("\n");
            }else{
                String[] members = groupMap.get(str);
                for(String member : members){
                    sb.append(member).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
