import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int basePrice = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];
        
        Map<String, Integer> carHistories = new HashMap<>();
        Map<String, Integer> inRecords = new HashMap<>();
        for(String record : records){
            String[] str = record.split(" ");
            StringTokenizer st = new StringTokenizer(str[0],":");
            String hour = st.nextToken();
            String minute = st.nextToken();
            int time = Integer.valueOf(hour)*60 + Integer.valueOf(minute);
            String carNumber = str[1];
            String command = str[2];
            
            if(command.equals("IN")){
                inRecords.put(carNumber, time);
            }else{
                int inTime = inRecords.get(carNumber);
                int diffTime = time - inTime;
                carHistories.put(carNumber, carHistories.getOrDefault(carNumber,0)+diffTime);
                inRecords.remove(carNumber);
            }
        }
        
        int endTime = 23*60 + 59;
        if(inRecords.size()>0){
            inRecords.forEach((k,v)-> carHistories.put(k, carHistories.getOrDefault(k,0)+endTime-v));
        }
        
        if(carHistories.containsKey("1234")){
            System.out.println(carHistories.get("1234"));
        }
        
        List<Car> list = new ArrayList<>();
        carHistories
            .forEach((k,v)-> 
                      {
                          if(v<=baseTime){
                             list.add(new Car(k,basePrice));
                          }else{
                             int total = unitPrice * (int)(Math.ceil((double)(v-baseTime)/unitTime)) + basePrice;
                              list.add(new Car(k,total));
                           }
                       }
                  );
        list.sort((a,b)->Integer.valueOf(a.number) - Integer.valueOf(b.number));
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).price;
         }
        
        return answer;
    }
    
    private class Car{
        String number;
        int price;
        
        Car(String number, int price){
            this.number = number;
            this.price = price;
        }
    }
}