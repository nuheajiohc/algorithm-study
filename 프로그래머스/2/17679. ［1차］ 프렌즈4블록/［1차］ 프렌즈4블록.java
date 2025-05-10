import java.util.*;

class Solution {
    
    private String broken = "0";
    private String blank = "-1";
    private int[] dx = {0,1,1};
    private int[] dy = {1,0,1};
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        String[][] blocks = new String[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                blocks[i][j] = String.valueOf(board[i].charAt(j));
            }
        }
        
        boolean removed=true;
        while(removed){
            removed = false;
            boolean[][] vis = new boolean[m][n];
            
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(blocks[i][j].equals(blank)) continue;
                    if(isSquare(blocks, i, j)){
                        checkVis(vis, i,j);
                        removed=true;
                    }
                }
            }
            
            int count=0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(vis[i][j]){
                        count++;
                    }
                }
            }
            
            downBlocks(blocks, vis, m,n);
            
            answer+=count;
        }
        return answer;
    }
    
    private boolean isSquare(String[][] blocks, int x, int y){
        for(int dir=0; dir<3; dir++){
            if(!blocks[x][y].equals(blocks[x+dx[dir]][y+dy[dir]])){
                return false;
            }
        }
        return true;
    }
    
    private void checkVis(boolean[][] vis, int x, int y){
        vis[x][y] = true;
        for(int dir=0; dir<3; dir++){
            vis[x+dx[dir]][y+dy[dir]]=true;
        }
    }
    
    private void downBlocks(String[][] blocks, boolean[][] vis, int m, int n){
        for(int j=0; j<n; j++){
            Deque<String> q = new ArrayDeque<>();
            for(int i=0; i<m; i++){
                if(blocks.equals(broken) || blocks.equals(blank)) continue;
                if(vis[i][j]) continue;
                q.offer(blocks[i][j]);
            }
            int gubun = m-q.size();
            for(int i=0; i<gubun; i++){
                blocks[i][j]=blank;
            }
            for(int i=gubun; i<m; i++){
                blocks[i][j]=q.poll();
            }
        }
    }
}