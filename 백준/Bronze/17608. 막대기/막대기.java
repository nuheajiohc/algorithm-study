import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=N-1; i>=0; i--){
            if(stack.isEmpty() || stack.peekLast()<arr[i]){
                stack.offerLast(arr[i]);
            }
        }

        System.out.println(stack.size());
    }
}
