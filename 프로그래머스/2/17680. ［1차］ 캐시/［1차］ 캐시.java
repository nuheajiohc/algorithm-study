import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0){
            return cities.length*5;
        }
        
        
        Set<String> set = new LinkedHashSet<>();
        
        for(String city : cities){
            city = city.toLowerCase();
            if(set.size()>0 && set.contains(city)){
                answer+=1;                
            }else{
                answer+=5;
            }
            
            if(set.contains(city)){
                set.remove(city);
                set.add(city);
            }else{
                if(set.size()==cacheSize){
                    set.remove(set.iterator().next());
                }
                set.add(city);
            }
        }
        
        return answer;
    }
}