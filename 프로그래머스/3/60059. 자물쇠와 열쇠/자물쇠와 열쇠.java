class Solution {
    
    private int groove=0;
    private int m, n;
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        m = key.length;
        n = lock.length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(lock[i][j]==0) groove++;
            }
        }
        
        for(int dir=0; dir<4; dir++){
            key = rotate(key);
            
            for(int i=-n; i<=n; i++){
                for(int j=-n; j<=n; j++){
                    if(check(key, lock, i, j)){
                        return true;
                    }
                }
            }
        }
        
        return answer;
    }
    
    public boolean check(int[][] key, int[][] lock, int i , int j){
        int count=0;

        for(int k=0; k<m; k++){
            for(int l=0; l<m; l++){
                int nx = i+k;
                int ny = j+l;
                if(nx<0 || ny<0 || nx>=n || ny >=n) continue;
                if(key[k][l]==1 && lock[nx][ny]==1) return false;
                if(key[k][l]==1 && lock[nx][ny]==0){
                    count++;
                }
            }
        }
        if(count==groove){
            return true;
        }
        return false;
    }
    
    public int[][] rotate(int[][] key){
        int[][] rotated = new int[m][m];
        for(int i=0; i<m; i++){
            for(int j=m-1; j>=0; j--){
                rotated[i][m-j-1] = key[j][i];
            }
        }
        return rotated;
    }
}