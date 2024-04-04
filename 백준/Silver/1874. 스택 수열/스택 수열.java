import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int count=1;

        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            while(stack.isEmpty() || stack.peekLast()<k){
                stack.offerLast(count);
                sb.append("+").append("\n");
                count++;
            }
            if(stack.peekLast()==k){
                stack.pollLast();
                sb.append("-").append("\n");
            }else if(stack.peekLast()>k){
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}
