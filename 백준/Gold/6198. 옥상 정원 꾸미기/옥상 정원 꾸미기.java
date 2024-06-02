import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] building = new int[N];
        for(int i=0; i<N; i++){
            building[i] = Integer.parseInt(br.readLine());
        }

        long totalHeight=0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=N-1; i>=0; i--){
            while(!stack.isEmpty() && building[i]>building[stack.peekLast()]){
                stack.pollLast();
            }

            if(!stack.isEmpty()){
                totalHeight += stack.peekLast()-i-1;
            }else{
                totalHeight += N-1-i;
            }
            stack.offerLast(i);
        }
        System.out.println(totalHeight);
    }
}
