import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        Map<String, String> memberInfos = new HashMap<>();
        List<ChatRoomHistory> histories = new ArrayList<>();
        for(String record : records){
            String[] infos = record.split(" ");
            String status = infos[0];
            String userID = infos[1];
            if(status.equals("Change")){
                String nickname = infos[2];    
                memberInfos.put(userID, nickname);
            }else if(status.equals("Enter")){
                String nickname = infos[2];    
                memberInfos.put(userID, nickname);
                histories.add(new ChatRoomHistory(userID, status));
            }else{
                histories.add(new ChatRoomHistory(userID, status));                
            }
        }
        
        String[] answer = new String[histories.size()];
        
        for(int i=0; i<histories.size(); i++){
            StringBuilder sb = new StringBuilder();
            ChatRoomHistory history = histories.get(i);
            sb.append(memberInfos.get(history.userID)).append("님이 ");
            if(history.status.equals("Enter")){
                sb.append("들어왔습니다.");
            }else{
                sb.append("나갔습니다.");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    public class ChatRoomHistory{
        String userID;
        String status;
        
        ChatRoomHistory(String userID, String status){
            this.userID = userID;
            this.status = status;
        }
    }
}