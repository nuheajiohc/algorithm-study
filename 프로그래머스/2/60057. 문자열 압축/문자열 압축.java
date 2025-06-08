class Solution {

    private int maxLen;
    
    public int solution(String s) {
        maxLen = s.length();
        int answer = maxLen;
        
        for(int len=1; len<=maxLen; len++){
            answer = Math.min(answer, calculateLen(s, len));
        }
        
        return answer;
    }
    
    public int calculateLen(String s, int len){
        int total = 0;
        Integer count = 0;
        String prev = s.substring(0, len);
        for(int i=0; i<maxLen; i+=len){
            String cur = s.substring(i, Math.min(i+len, maxLen));
            if(prev.equals(cur)){
                count ++;
            }else{
                prev = cur;
                total += len;
                if(count>1){
                    total += count.toString().length();
                }
                count = 1;
            }
        }
        
        if(count>1){
            total += count.toString().length();
        }
        total += prev.length();
        return total;
    }
}