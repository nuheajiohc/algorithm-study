import java.util.*;

class Solution {
    
    private double[] discountRatio;
    private double[] ratio = {0.1, 0.2, 0.3, 0.4};
    private int subscriber=-1;
    private int amount=-1;
    
    public int[] solution(int[][] users, int[] emoticons) {
        discountRatio = new double[emoticons.length];
        btk(users, emoticons, 0);
        int[] answer = {subscriber, amount};
        return answer;
    }
    
    public void btk(int[][] users, int[] emoticons, int cur){
        if(cur==emoticons.length){
            int temp_subscriber=0;
            int temp_amount=0;
            for(int i=0; i<users.length; i++){
                double user_amount=0;
                for(int j=0; j<emoticons.length; j++){
                    if(users[i][0]<=discountRatio[j]*100){
                        user_amount += emoticons[j]*(1-discountRatio[j]);
                    }
                }
                
                if(user_amount < users[i][1]){
                    temp_amount+=user_amount;
                }else{
                    temp_subscriber++;
                }
            }
            if(subscriber<temp_subscriber){
                subscriber = temp_subscriber;
                amount = temp_amount;
            }else if(subscriber==temp_subscriber){
                amount = Math.max(amount, temp_amount);
            }
            return;
        }
        
        for(int i=0; i<4; i++){
            discountRatio[cur] = ratio[i];
            btk(users, emoticons, cur+1);
        }
        
    }
}