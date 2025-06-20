import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> reportedStats = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>();
        for(String id : id_list){
            reportedStats.put(id, new HashSet<>());
            map.put(id, new HashSet<>());
        }
        
        for(String content : report){
            StringTokenizer st = new StringTokenizer(content, " ");
            String reporter = st.nextToken();
            String respondent = st.nextToken();
            Set<String> reportedStat = reportedStats.get(respondent);
            reportedStat.add(reporter);
            reportedStats.put(respondent, reportedStat);
            
            Set<String> set = map.get(reporter);
            set.add(respondent);
            map.put(reporter, set);
        }
        
        for(int i=0; i<id_list.length; i++){
            String reporter = id_list[i];
            Set<String> respondents = map.get(reporter);
            for(String respondent : respondents){
                if(reportedStats.get(respondent).size()>=k){
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}