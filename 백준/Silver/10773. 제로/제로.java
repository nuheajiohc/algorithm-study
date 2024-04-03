import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int count=0;
        for(int i=0; i<K;i++){
            stack.offerLast(Integer.parseInt(br.readLine()));
            if(stack.peekLast()==0){
                stack.pollLast();
                stack.pollLast();
            }
        }
        for(int n:stack){
            count+=n;
        }
        System.out.println(count);
    }
}
