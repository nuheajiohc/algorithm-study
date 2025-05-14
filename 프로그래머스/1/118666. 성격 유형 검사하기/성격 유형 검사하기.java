class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        
        int R = 0;
        int T = 0;
        int C = 0;
        int F = 0;
        int J = 0;
        int M = 0;
        int A = 0;
        int N = 0;
        
        for(int i=0; i<choices.length; i++){
            String question = survey[i];
            int choice = choices[i];
            
            if(question.contains("A")){
                if(choice==4) continue;
                if(choice>4){
                    if(question.charAt(1)=='N'){
                        N += choice-4;
                    }else{
                        A += choice-4;
                    }
                }else{
                    if(question.charAt(0)=='N'){
                        N += 4-choice;
                    }else{
                        A += 4-choice;
                    }
                }
            }else if(question.contains("C")){
                if(choice==4) continue;
                if(choice>4){
                    if(question.charAt(1)=='C'){
                        C += choice-4;
                    }else{
                        F += choice-4;
                    }
                }else{
                    if(question.charAt(0)=='C'){
                        C += 4-choice;
                    }else{
                        F += 4-choice;
                    }
                }
            }else if(question.contains("M")){
                if(choice==4) continue;
                if(choice>4){
                    if(question.charAt(1)=='M'){
                        M += choice-4;
                    }else{
                        J += choice-4;
                    }
                }else{
                    if(question.charAt(0)=='M'){
                        M += 4-choice;
                    }else{
                        J += 4-choice;
                    }
                }
            }else{
                if(choice==4) continue;
                if(choice>4){
                    if(question.charAt(1)=='R'){
                        R += choice-4;
                    }else{
                        T += choice-4;
                    }
                }else{
                    if(question.charAt(0)=='R'){
                        R += 4-choice;
                    }else{
                        T += 4-choice;
                    }
                }
            }
        }
        
        
        if(R>=T){
            answer.append("R");
        }else{
            answer.append("T");
        }
        
        if(C>=F){
            answer.append("C");
        }else{
            answer.append("F");
        }
        
        if(J>=M){
            answer.append("J");
        }else{
            answer.append("M");
        }
        
        if(A>=N){
            answer.append("A");
        }else{
            answer.append("N");
        }
        
        return answer.toString();
    }
}