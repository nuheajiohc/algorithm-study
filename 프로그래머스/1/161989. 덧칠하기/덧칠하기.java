class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int st=0;
        int en=0;
        while(st<section.length){
            while(en+1<section.length && section[en+1]-section[st]<m){
                en++;
            }
            answer++;
            st=en+1;
        }        
        return answer;
    }
}