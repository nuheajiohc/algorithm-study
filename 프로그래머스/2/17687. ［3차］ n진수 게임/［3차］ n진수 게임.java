import java.util.*;

class Solution {
    
    private static Map<Integer, String> map = new HashMap<>();
    
    public String solution(int n, int t, int m, int p) {
        map.put(10,"A");
        map.put(11,"B");
        map.put(12,"C");
        map.put(13,"D");
        map.put(14,"E");
        map.put(15,"F");
        
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        int i=1;
        while(sb.length()<=100000){
            sb.append(toRadix(i, n));
            i++;
        }
        StringBuilder answer = new StringBuilder();
        int c =0;
        while(answer.length()<t){
            answer.append(sb.charAt(p-1+(m*c)));
            c++;
        }
        return answer.toString();
    }
    
    private StringBuilder toRadix(int n, int r){
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            String s = String.valueOf(n%r);
            if((n%r)>=10){
                s = map.get(n%r);
            }
            sb.append(s);
            n/=r;
            if(n==0) break;
        }
        return sb.reverse();
    }
}