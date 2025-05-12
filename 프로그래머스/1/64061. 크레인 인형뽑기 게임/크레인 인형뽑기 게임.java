import java.util.*;

class Solution {
    
    private int EMPTY = 0;
    private int width;
    private int height;
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        width = board[0].length;
        height = board.length;
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int move : moves){
            int doll = pickDoll(board, move-1);
            if(doll == EMPTY) continue;
            answer += countDisapearedDoll(stack, doll);
        }
        return answer;
    }
    
    private int pickDoll(int[][] board, int cur){
        for(int i=0; i<height; i++){
            if(board[i][cur] > EMPTY){
                int result = board[i][cur];
                board[i][cur]=EMPTY;
                return result;
            }
        }
        return EMPTY;
    }
    
    private int countDisapearedDoll(Deque<Integer> stack, int doll){
        if(stack.isEmpty()){
            stack.offerLast(doll);
            return 0;
        }
        
        if(stack.peekLast() == doll){
            stack.pollLast();
            return 2;
        }
        
        stack.offerLast(doll);
        return 0;
    }
}