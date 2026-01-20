import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String parentheses = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();

        int sum = 0;
        int idx = 0;

        while(idx< parentheses.length()){
            char cur = parentheses.charAt(idx);
            if(cur == '('){
                idx++;
                char next = parentheses.charAt(idx);
                if(next == ')'){
                    sum += stack.size();
                    idx++;
                }else{
                    stack.offerLast(cur);
                }
            }else{
                stack.pollLast();
                sum += 1;
                idx++;
            }
        }
        System.out.println(sum);
    }
}
