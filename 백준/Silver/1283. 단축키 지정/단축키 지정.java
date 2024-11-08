import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            String line = br.readLine();
            String[] words = line.split(" ");
            int idx=-1;
            for(int j=0; j<words.length; j++){
                char c = words[j].charAt(0);
                char lowerCase = toLowerCase(c);
                if(!set.contains(lowerCase)){
                    set.add(lowerCase);
                    idx = j;
                    break;
                }
            }

            if(idx==-1){
                boolean flag=false;
                for(int j=0; j<line.length(); j++){
                    char c = line.charAt(j);
                    char lowerCase = toLowerCase(c);
                    if(!flag && c!=' ' && !set.contains(lowerCase)){
                        set.add(lowerCase);
                        sb.append("[").append(c).append("]");
                        flag=true;
                    }else{
                        sb.append(String.valueOf(c));
                    }
                }
            }else{
                for(int j=0; j<words.length; j++){
                    if(j!=idx){
                        sb.append(words[j]).append(" ");
                    }else{
                        sb.append("[");
                        sb.append(String.valueOf(words[j].charAt(0)));
                        sb.append("]");
                        sb.append(words[j].substring(1));
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static char toLowerCase(char c){
        if(c>='a'){
            return (char)(c-32);
        }
        return c;
    }
}
