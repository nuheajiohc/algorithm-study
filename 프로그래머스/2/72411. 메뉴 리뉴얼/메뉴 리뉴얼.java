import java.util.*;

class Solution {
    
    private Map<Integer, Map<String, Integer>> countMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for(int len : course){
            countMap.put(len, new HashMap<>());
        }
        
        for(String order : orders){
            char[] carr = order.toCharArray();
            Arrays.sort(carr);
            order = new String(carr);
            for(int len : course){
                if(order.length()<len) continue;
                btk(order, len, 0, new StringBuilder());
            }
        }
        
        List<String> list = new ArrayList<>();
        for(int len : course){
            Map<String, Integer> freq = countMap.get(len);
            if(freq.isEmpty()) continue;
            int max = Collections.max(freq.values());
            if(max<2) continue;
            
            for(Map.Entry<String, Integer> e : freq.entrySet()){
                if(e.getValue()==max){
                    list.add(e.getKey());
                }
            }
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void btk(String order, int len, int k, StringBuilder sb){
        if(sb.length()==len){
            Map<String, Integer> map = countMap.get(len);
            String target = sb.toString();
            map.put(target, map.getOrDefault(target, 0)+1);
            return;
        }
        
        for(int i=k; i<order.length(); i++){
            sb.append(order.charAt(i));
            btk(order, len, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}