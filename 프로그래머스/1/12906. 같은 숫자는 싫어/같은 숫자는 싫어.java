import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int num : arr){
            if(stack.isEmpty() || stack.peekLast()!=num){
                stack.offer(num);
            }
        }
        
        return stack.stream().mapToInt(i->i).toArray();
    }
}