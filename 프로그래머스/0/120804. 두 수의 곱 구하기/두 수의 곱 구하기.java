import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int solution(int num1, int num2) {
        // int answer = num1*num2;
        // return answer;
        
        return Stream.of(num1, num2).reduce(1,(sum, value)->sum*value);
    }
}