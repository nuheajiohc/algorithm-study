import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        Map<Character, int[]> map = new HashMap<>();
        map.put('1', new int[]{0,0});
        map.put('2', new int[]{0,1});
        map.put('3', new int[]{0,2});
        map.put('4', new int[]{1,0});
        map.put('5', new int[]{1,1});
        map.put('6', new int[]{1,2});
        map.put('7', new int[]{2,0});
        map.put('8', new int[]{2,1});
        map.put('9', new int[]{2,2});
        map.put('*', new int[]{3,0});
        map.put('0', new int[]{3,1});
        map.put('#', new int[]{3,2});
        
        char leftPosition = '*';
        char rightPosition = '#';
        
        for(int number: numbers){
            if(number == 1 || number == 4 || number == 7){
                leftPosition = toChar(number);
                answer.append("L");
            }else if(number == 3 || number == 6 || number == 9){
                rightPosition = toChar(number);
                answer.append("R");
            }else{
                int[] left = map.get(leftPosition);
                int[] right = map.get(rightPosition);
                int[] cur = map.get(toChar(number));
                
                int leftDistance = Math.abs(left[0]-cur[0]) + Math.abs(left[1]-cur[1]);
                int rightDistance = Math.abs(right[0]-cur[0]) + Math.abs(right[1]-cur[1]);
                if(leftDistance > rightDistance){
                    rightPosition = toChar(number);
                    answer.append("R");
                }else if(leftDistance < rightDistance){
                    leftPosition = toChar(number);
                    answer.append("L");
                }else{
                    if(hand.equals("left")){
                        leftPosition = toChar(number);
                        answer.append("L");
                    }else{
                        rightPosition = toChar(number);
                        answer.append("R");
                    }
                }
            }
        }
        return answer.toString();
    }
    
    public char toChar(int n){
        return (char)('0'+n);
    }
}