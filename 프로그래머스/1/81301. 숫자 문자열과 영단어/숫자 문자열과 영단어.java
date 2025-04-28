import java.util.*;

class Solution {
    public int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<String, String> map = new HashMap<>();
        for(int i=0 ;i<10; i++){
            map.put(arr[i], String.valueOf(i));
        }
        
        for(String target : arr){
            s = String.join(map.get(target), s.split(target,-1));
        }
        
        return Integer.valueOf(s);
    }
}