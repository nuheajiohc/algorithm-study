import java.util.*;

class Solution {
    public String solution(String s) {
        char[] toChar = s.toCharArray();
        Arrays.sort(toChar);
        StringBuilder sb = new StringBuilder();
        String answer = sb.append(toChar).reverse().toString();
        return answer;
    }
}