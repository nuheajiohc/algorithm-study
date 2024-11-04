import java.io.*;

public class Main {

    private static final int POSSIBLE_SAME_LEN=1;
    private static final int POSSIBLE_DIFF_LEN=2;
    private static final int IMPOSSIBLE=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count=0;
        String target = br.readLine();
        int[] targetAlpha = new int[26];
        for(int i=0; i<target.length(); i++){
            targetAlpha[target.charAt(i)-'A'] ++;
        }
        for(int i=0; i<N-1; i++){
            String word = br.readLine();
            if(Math.abs(target.length()-word.length())>1) continue;
            int[] wordAlpha = new int[26];
            for(int j=0; j<word.length(); j++){
                wordAlpha[word.charAt(j)-'A']++;
            }

            if(word.length()==target.length()){
                if(isPossible(wordAlpha, targetAlpha)==POSSIBLE_SAME_LEN){
                    count++;
                }
            }else{
                if(isPossible(wordAlpha, targetAlpha)==POSSIBLE_DIFF_LEN){
                    count++;
                }
            }

        }
        System.out.println(count);
    }

    public static int isPossible(int[] a, int[] b){
        int diffCnt=0;
        for(int i=0; i<26; i++){
            if(a[i]!=b[i]){
                if(Math.abs(a[i]-b[i])>1){
                    return IMPOSSIBLE;
                }
                diffCnt++;
            }
        }
        if(diffCnt==2 || diffCnt==0){
            return POSSIBLE_SAME_LEN;
        }
        else if(diffCnt==1){
            return POSSIBLE_DIFF_LEN;
        }else{
            return IMPOSSIBLE;
        }
    }
}
