import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        m = convert(m);

        int maxTime=0;
        for(String musicinfo : musicinfos){
            StringTokenizer st = new StringTokenizer(musicinfo, ",");
            String startTime = st.nextToken();
            String endTime = st.nextToken();
            String title = st.nextToken();
            String info = convert(st.nextToken());
            
            int time = findTimeDiff(startTime, endTime);
            
            if(time < m.length()) continue;
            if(time > info.length()){
                info = info.repeat(time/info.length());
                if(time%info.length()!=0){
                    info += info.substring(0, time%info.length());
                }
            }else{
                info = info.substring(0, time);    
            }

            if(info.contains(m) && maxTime < time){
                answer = title;
                maxTime = time;
            }
        }
        
        if(answer.equals("")){
            answer = "(None)";
        }
        
        return answer;
    }
    
    public String convert(String str){
        return str.replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a").replace("B#","b");
    }
       
    public int findTimeDiff(String startTime, String endTime){
        StringTokenizer st = new StringTokenizer(startTime, ":");
        int startHour = Integer.parseInt(st.nextToken());
        int startMinute = Integer.parseInt(st.nextToken());
        int startMinuteSum = startHour*60 + startMinute;
        
        st = new StringTokenizer(endTime, ":");
        int endHour = Integer.parseInt(st.nextToken());
        int endMinute = Integer.parseInt(st.nextToken());
        int endMinuteSum = endHour*60 + endMinute;
        
        return endMinuteSum - startMinuteSum;
    }
}