class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        int size = queue1.length;
        int[] merged = new int[2*size];
        
        long sum = 0;
        for(int v : queue1) sum+=v;
        long curSum = sum;
        for(int v : queue2) sum+=v;
        
        if((sum&1) == 1) return -1;
        
        for(int i=0; i<size; i++){
            merged[i] = queue1[i];
            merged[size+i] = queue2[i];
        }
        long target = sum/2;
        
        int st=0;
        int en=size;
        while(st<2*size && en<2*size){
            if(curSum<target){
                curSum+=merged[en];
                en++;
            }else if(curSum>target){
                curSum-=merged[st];
                st++;
            }else{
                return answer;
            }
            answer++;
        }
        
        return -1;
    }
}