import java.util.*;

class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String converted = Integer.toString(n, k);
        String[] arr = converted.split("0",-1);

        for(String tmp : arr){
            if(tmp.equals("")) continue;
            Long number = Long.valueOf(tmp);
            if(isPrime(number)){
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isPrime(long number){
        if(number==1) return false;
        for(long i=2; i<=(long)Math.sqrt(number); i++){
            if(number%i==0) return false;
        }
        return true;
        
    }
}