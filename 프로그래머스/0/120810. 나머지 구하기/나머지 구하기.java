import java.util.stream.*;

class Solution {
    public int solution(int num1, int num2) {
        return Stream.of(num1, num2).reduce((a,b)->a%b).get();
    }
}