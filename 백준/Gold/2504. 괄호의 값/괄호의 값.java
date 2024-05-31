import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();

        int result = 0;
        int temp = 1;
        for(int i=0; i<input.length(); i++){
            char value = input.charAt(i);
            if(value=='('){
                temp*=2;
                stack.offer('(');
            }else if(value=='['){
                temp*=3;
                stack.offer('[');
            }else if(value==')'){
                if(!stack.isEmpty() && stack.peekLast()=='('){
                    if(input.charAt(i-1)=='('){
                        result+=temp;
                    }
                    stack.pollLast();
                    temp/=2;
                }else{
                    result=0;
                    break;
                }
            }else{
                if(!stack.isEmpty() && stack.peekLast()=='['){
                    if(input.charAt(i-1)=='['){
                        result+=temp;
                    }
                    stack.pollLast();
                    temp/=3;
                }else{
                    result=0;
                    break;
                }
            }
        }
        if(!stack.isEmpty()) result=0;
        System.out.println(result);
     }
}
