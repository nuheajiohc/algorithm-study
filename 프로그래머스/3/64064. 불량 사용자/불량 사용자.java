class Solution {
    
    private boolean[] vis;
    private boolean[] bit;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        vis = new boolean[user_id.length];
        bit = new boolean[(1<<user_id.length)+1];
        return btk(user_id, banned_id, 0, 0);
    }
    
    public int btk(String[] user_id, String[] banned_id, int k, int b){
        if(k==banned_id.length){
            if(bit[b]) return 0;
            bit[b]=true;
            return 1;
        }
        
        int count=0;
        for(int i=0; i<user_id.length; i++){
            if(vis[i]) continue;
            if(isCandidate(user_id[i], banned_id[k])){
                vis[i] = true;
                count += btk(user_id, banned_id, k+1, b|(1<<i));
                vis[i] = false;
            }    
        }
        
        return count;
    }
    
    public boolean isCandidate(String user, String banned){
        if(user.length() != banned.length()) return false;
        
        for(int i=0; i<user.length(); i++){
            if(!(banned.charAt(i)=='*' || banned.charAt(i)== user.charAt(i))){
                return false;
            }
        }
        return true;
    }

}