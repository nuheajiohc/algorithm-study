import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(String gem : gems){
            set.add(gem);
        }
        int uniqueGemSize = set.size();

        int minSt=0;
        int minEn=100000;
        int st=0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int en=0; en<gems.length; en++){
            if(!map.containsKey(gems[en])){
                map.put(gems[en],1);
            }else{
                map.put(gems[en], map.get(gems[en])+1);
            }
            
            while(map.size()>=uniqueGemSize && map.get(gems[st])>1){
                map.put(gems[st],map.get(gems[st])-1);
                st++;
            }
            
            if(map.size()>=uniqueGemSize && en-st<minEn-minSt){
                minEn = en;
                minSt = st;
            }
        }
        
        
        
        return new int[]{minSt+1, minEn+1};
    }
}