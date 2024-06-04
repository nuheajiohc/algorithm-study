class Solution {
    public String solution(String phone_number) {
        int count = phone_number.length()-4;
        String answer = "*".repeat(count)+phone_number.substring(count);
        return answer;
    }
}