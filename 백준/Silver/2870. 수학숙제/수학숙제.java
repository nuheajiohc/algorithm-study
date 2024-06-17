import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        while(N-->0){
            String[] s = br.readLine().split("[a-z]+");
            for(String n : s){
                if(n.isEmpty()) continue;
                int st=0;
                while(st<n.length()){
                    if(n.charAt(st)=='0'){
                        st++;
                    }else break;
                }
                n = n.substring(st);
                if(n.isEmpty()) n="0";
                list.add(n);
            }
        }

        Collections.sort(list,(a,b)->{
            if(a.length()!=b.length()){
                return a.length()-b.length();
            }else{
                return a.compareTo(b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String n : list){
            sb.append(n).append("\n");
        }
        System.out.println(sb.toString());
    }
}
