import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        
        int idx=0;
        for(int i=0; i<3; i++){
            char c = dartResult.charAt(idx);
            if(c>='0' && c<='9'){
                int n = c-'0';
                if(c=='1' && dartResult.charAt(idx+1)=='0'){
                    idx++;
                    n = 10;
                }
                char next = dartResult.charAt(++idx);
                while(next<'0' || next>'9'){
                    if(next=='S'){
                        n = n;
                    }else if(next=='D'){
                        n = n*n;
                    }else if(next=='T'){
                        n = n*n*n;
                    }else if(next=='#'){
                        n = n * (-1);
                    }else{
                        n = n * 2;
                        if(i!=0){
                            score[i-1] = score[i-1]*2;
                        }
                    }
                    if(idx==dartResult.length()-1) break;
                    next = dartResult.charAt(++idx);
                }
                score[i]=n;
            }
        }
        
        int answer = score[0]+score[1]+score[2];
        
        return answer;
    }
}