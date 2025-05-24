class Solution {
    private int zeroNum;
    private int count;
    
    public int[] solution(String s) {        
        recursion(s, 0, 0);
        
        int[] answer = {count, zeroNum};
        return answer;
    }
    
    public void recursion(String s, int zeroNum, int count){
        if(s.equals("1")){
            this.zeroNum = zeroNum;
            this.count = count;
            return;
        }
        int zero = countZero(s);
        int one = s.length()-zero;
        recursion(Integer.toString(one,2), zeroNum + countZero(s), count+1);
    }
    
    public int countZero(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                count++;
            }
        }
        return count;
    }
    
    public boolean isOnlyOne(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                return false;
            }
        }
        return true;
    }
}