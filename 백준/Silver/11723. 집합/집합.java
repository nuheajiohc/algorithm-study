import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "add":
                    int x = Integer.parseInt(st.nextToken());
                    set.add(x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    set.remove(x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append(set.contains(x)?1:0).append("\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    if(set.contains(x)){
                        set.remove(x);
                    }else{
                        set.add(x);
                    }
                    break;
                case "all":
                    for(int i=1; i<=20; i++){
                        set.add(i);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}
