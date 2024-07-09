import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            String ps = br.readLine();
            if(isVPS(ps)) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean isVPS(String ps){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<ps.length(); i++){
            char c = ps.charAt(i);
            if(c =='('){
                stack.offerLast(c);
            }else{
                if(stack.isEmpty()) return false;
                else{
                    if(stack.peekLast()=='('){
                        stack.pollLast();
                    }else{
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
