import java.util.*;

class Solution {
    
    private boolean[] vis;
    private int columns, rows;
    
    public int solution(String[][] relations) {
        int answer = 0;

        rows = relations.length;
        columns = relations[0].length;
        int len = 1<<columns;
        vis = new boolean[len+1];
        
        for(int bit=1; bit<=len; bit++){
            if(exists(vis, bit)){
                continue;
            }
            
            boolean[] candidates = findCandidate(bit);
            Set<String> set = new HashSet<>();
            int prevLen =set.size();
            
            for(int i=0; i<rows; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<columns; j++){
                    if(candidates[j]){
                        sb.append(relations[i][j]);
                    }
                }
                set.add(sb.toString());
            }
            if(set.size()==rows){
                vis[bit]=true;
                answer++;
            }
        }
            
        return answer;
    }
    
    public boolean exists(boolean[] vis, int bit){
        for(int i=0; i<=bit; i++){
            if(vis[i] && ((i & bit) == i)){
                return true;
            }
        }
        return false;
    }
    
    public boolean[] findCandidate(int bit){
        boolean[] candidates = new boolean[columns];
        for(int i=0; i<columns; i++){
            if(((bit>>i) & 1) == 1){
                candidates[i]=true;
            }
        }
        return candidates;
    }
}