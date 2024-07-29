import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String t = st.nextToken();
            int idx = findIndexOfX(s);
            sb.append(String.valueOf(t.charAt(idx)).toUpperCase());
        }

        System.out.println(sb.toString());
    }

    public static int findIndexOfX(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='x' || str.charAt(i)=='X') return i;
        }
        return -1;
    }
}
