import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable){
            StringTokenizer st = new StringTokenizer(time, ":");
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            pq.offer(hour*60 + minute);
        }
        
        int start = 9*60 -t;
        int last = 0;
        boolean remaining = true;
        for(int i=0; i<n; i++){
            start+=t;
            int cur=0;
            for(int j=0; j<m; j++){
                if(pq.isEmpty()) break;
                if(start < pq.peek()) break;
                cur++;
                last = pq.poll();
            }
            
            if(cur<m) remaining = true;
            else remaining = false;
        }
        
        if(remaining){
            last = start;
        }else{
            last-=1;
        }
        
        String hour = String.format("%02d",last/60);
        String minute = String.format("%02d",last%60);
        
        return hour+":"+minute;
    }
}