import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int[] alpha = new int[26];
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if('a'<=c){
                alpha[c-'a']++;
            }else{
                alpha[c-'A']++;
            }
        }

        int maxIdx=0;
        int count=1;
        for(int i=1; i<26; i++){
            if(alpha[maxIdx]<alpha[i]){
                maxIdx = i;
                count=1;
            }else if(alpha[maxIdx]==alpha[i]){
                count++;
            }
        }

        if(count>1){
            System.out.println("?");
        }else{
            System.out.println((char)(maxIdx+'A'));
        }
        
    }
}
