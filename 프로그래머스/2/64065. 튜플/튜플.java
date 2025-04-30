import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] count = new int[100001];
        
        String[] splitted = s.substring(2,s.length()-2).split("\\},\\{");
        for(String str : splitted){
            StringTokenizer st = new StringTokenizer(str, ",");
            while(st.hasMoreTokens()){
                count[Integer.valueOf(st.nextToken())]++;
            }
        }
        
        List<int[]> list = new ArrayList<>();
        for(int i=1; i<100001; i++){
            if(count[i]>0){
                list.add(new int[]{i, count[i]});
            }
        }
        
        list.sort((a,b)->b[1]-a[1]);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = (list.get(i))[0];
        }
        
        return answer;
    }
}