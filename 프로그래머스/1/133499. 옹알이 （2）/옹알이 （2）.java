class Solution {
    
    String[] prons = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        for(String word: babbling){
            if(canPron(word)){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean canPron(String word){
        for(String pron: prons){
            if(word.length()!= word.replaceAll(pron+pron,"").length()) return false;
        }
        
        for(String pron: prons){
            word = word.replaceAll(pron," ");
        }
        if(word.isBlank()){
            return true;
        }
        return false;
    }
}