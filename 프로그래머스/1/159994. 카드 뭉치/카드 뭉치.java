class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int curPos1=0;
        int curPos2=0;
        for(String word: goal){
            if(curPos1<cards1.length && cards1[curPos1].equals(word)){
                curPos1++;
            }else if(curPos2<cards2.length && cards2[curPos2].equals(word)){
                curPos2++;
            }else{
                answer = "No";
                break;
            }
        }
        return answer;
    }
}