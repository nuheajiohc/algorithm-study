import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer ,Integer> count = new HashMap<>();
        
        String[] splitted = s.substring(2,s.length()-2).split("\\},\\{");
        for(String str : splitted){
            StringTokenizer st = new StringTokenizer(str, ",");
            while(st.hasMoreTokens()){
                int value = Integer.valueOf(st.nextToken());
                if(count.containsKey(value)){
                    count.put(value, count.get(value)+1);
                }else{
                    count.put(value, 1);
                }
            }
        }
        
        List<int[]> list = new ArrayList<>();
        count.forEach((key, value)-> list.add(new int[]{key, value}));
        list.sort((a,b)->b[1]-a[1]);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = (list.get(i))[0];
        }
        
        return answer;
    }
}
