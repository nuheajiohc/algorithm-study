import java.util.*;

class Solution {
    
    private int size = 5;
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[size];
        
        for(int i=0; i<size; i++){
            char[][] place = new char[size][size];
            for(int j=0; j<size; j++){
                place[j] = places[i][j].toCharArray();
            }
            
            if(isPossible(place)){
                answer[i] = 1;
            }
        }
        return answer;
    }
    
    public boolean isPossible(char[][] place){
        for(int j=0; j<size; j++){
            for(int k=0; k<size; k++){
                if(place[j][k]=='P'){
                    boolean[][] vis = new boolean[size][size];
                    vis[j][k] = true;
                    if(!dfs(place, vis, j, k, 0)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean dfs(char[][] place, boolean[][] vis, int x, int y, int dist){
        if(dist==2){
            return true;
        }
        
        boolean check = true;
        
        for(int dir=0; dir<4; dir++){
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(nx<0 || nx>=size || ny<0 || ny>=size) continue;
            if(vis[nx][ny]) continue;
            if(place[nx][ny]=='X') continue;
            if(place[nx][ny]=='P') return false;
            vis[nx][ny] = true;
            check = dfs(place, vis, nx, ny, dist+1);
            if(check==false){
                return false;
            }
        }
        
        return check;
    }
}