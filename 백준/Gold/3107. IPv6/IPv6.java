import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String shortIPv6 = br.readLine().replaceAll("::",":group:");
        List<String> list = new ArrayList<>();

        String[] arr = shortIPv6.split(":");
        for(String s : arr){
            if(s.isEmpty()) continue;
            if(s.length()<4){
                list.add("0".repeat(4-s.length())+s);
            }else{
                list.add(s);
            }
        }
        String[] IPv6 = new String[8];
        int idx=0;
        for(String s : list){
            if(s.equals("group")){
                int count=8-list.size()+1;
                while(count-->0){
                    IPv6[idx] = "0000";
                    idx++;
                }
            }else{
                IPv6[idx] = s;
                idx++;
            }
        }
        System.out.println(String.join(":",IPv6));
    }
}
