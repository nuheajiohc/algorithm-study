import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        KakaoDate todayDate = KakaoDate.fromToday(today);
        
        Map<String, Integer> termsMap = new HashMap<>();
        for(String term : terms){
            StringTokenizer st = new StringTokenizer(term);
            termsMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            KakaoDate privacyDate = KakaoDate.fromPrivacy(privacies[i]);
            int term = termsMap.get(privacyDate.kinds);
            int year = privacyDate.year;
            int month = privacyDate.month;
            int day = privacyDate.day;
            int a = (month+term)%12;
            int b = (month+term)/12;
            if(a==0){
                year+=b-1;
                month = 12;
            }else{
                year+=b;
                month = a;
            }
            
            if(todayDate.year>year){
                list.add(i+1);
            }else if(todayDate.year==year){
                if(todayDate.month>month){
                    list.add(i+1);
                }else if(todayDate.month==month){
                    if(todayDate.day>=day){
                        list.add(i+1);
                    }
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public static class KakaoDate{
        int year;
        int month;
        int day;
        String kinds;
        
        public KakaoDate(int year, int month, int day, String kinds){
            this.year = year;
            this.month = month;
            this.day = day;
            this.kinds = kinds;
        }
        
        public KakaoDate(int year, int month, int day){
            this(year, month, day, null);
        }
                
        public static KakaoDate fromToday(String today){
            StringTokenizer st = new StringTokenizer(today, ".");
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            return new KakaoDate(year, month, day);
        }
        
        public static KakaoDate fromPrivacy(String privacies){
            StringTokenizer st = new StringTokenizer(privacies);
            String date = st.nextToken();
            String kinds = st.nextToken();
                
            st = new StringTokenizer(date, ".");
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            return new KakaoDate(year, month, day, kinds);
        }
    }
}