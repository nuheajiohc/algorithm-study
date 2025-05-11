import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();
        long sum1=0;
        long sum2=0;
        for(long v : queue1){
            q1.offer(v);
            sum1+=v;
        }
        for(long v :queue2){
            q2.offer(v);
            sum2+=v;
        }
        int limit = q1.size()*3 -1;
        int count1=q1.size();
        int count2=q2.size();
        
        int answer = 0;
        
        
        while(true){
            if(sum1 < sum2){
                count2-=1;
                long tmp = q2.poll();
                q1.offer(tmp);
                sum2-=tmp;
                sum1+=tmp;
            }else if(sum1 > sum2){
                count1-=1;
                long tmp = q1.poll();
                q2.offer(tmp);
                sum2+=tmp;
                sum1-=tmp;
            }else{
                break;
            }
            
            if(answer>limit){
                return -1;
            }
            answer++;
        }
         
        
        return answer;
    }
}