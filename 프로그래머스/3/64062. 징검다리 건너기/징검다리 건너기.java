class Solution {
    public int solution(int[] stones, int k) {
        int st=1;
        int en=200000000+k;
        
        while(st+1<en){
            int mid = (st+en)/2;
            if(canSkip(stones, k, mid)) st = mid;
            else en = mid;
        }
        return st;
    }
    
    public boolean canSkip(int[] stones, int k, int target){
        int count=0;
        for(int stone : stones){
            if(stone<target){
                count++;
            }else{
                count=0;
            }
            if(count==k){
                return false;
            }
        }
        return true;
    }
}