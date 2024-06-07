import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int num : arr){
            if(stack.isEmpty() || num!=stack.peekLast()){
                stack.offer(num);
            }
        }
        
        int[] answer = new int[stack.size()];
        for(int i=0; i<answer.length; i++){
            answer[i]= stack.pollFirst();
        }           
        return answer;
    }
}