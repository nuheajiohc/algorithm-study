import java.util.*;

class Solution {
    
    private int[][] board;
    private int[][][] costs;
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] board) {
        this.board = board;
        this.costs = new int[board.length][board.length][4];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }
        
        return dfs(0,0, -1, 0);
    }
    
    public int dfs(int x, int y, int dir, int sum){
        if(x == board.length-1 && y == board.length-1){
            return sum;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int d=0; d<4 ; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0 || nx>=board.length || ny<0 || ny>=board.length) continue;
            if(board[nx][ny]==1) continue;
            
            int extra = (dir==d || dir==-1) ? 100 : 600; 
            int ncost = sum + extra;
            
            if(costs[nx][ny][d]<=ncost || ncost>=min) continue;
            costs[nx][ny][d] = ncost;
            min = Math.min(min, dfs(nx, ny, d, ncost));
        }
        
        return min;
    }
}