import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int stage: stages){
            if(map.containsKey(stage)){
                map.put(stage, map.get(stage)+1);
            }else{
                map.put(stage, 1);
            }
        }
        
        double[][] failRates = new double[N][2];
        int rest=stages.length;
        for(int i=0; i<N; i++){
            if(map.containsKey(i+1)){
                failRates[i] = new double[]{i+1, map.get(i+1)/(double)rest};
                rest-=map.get(i+1);
            }else{
                failRates[i] = new double[]{i+1, 0};
            }
        }
        
        Arrays.sort(failRates, (a,b)->Double.compare(b[1],a[1]));
        
        
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = (int)failRates[i][0];
        }
        
        return answer;
    }
}