import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=1; i<=26; i++){
            map.put(Character.toString('A'+i-1), i);
        }
        
        List<Integer> list = new ArrayList<>();
        
        ArrayDeque<String> q = new ArrayDeque<>();
        for(int i=0; i<msg.length(); i++){
            q.offer(Character.toString(msg.charAt(i)));
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            String tmp = q.poll();
            sb.append(tmp);
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(), map.size()+1);
                sb.deleteCharAt(sb.length()-1).toString();
                list.add(map.get(sb.toString()));
                q.offerFirst(tmp);
                sb.setLength(0);
            }
        }
        list.add(map.get(sb.toString()));
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}