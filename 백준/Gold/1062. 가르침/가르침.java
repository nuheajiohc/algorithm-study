import java.io.*;
import java.util.*;

public class Main {

    private static int N,K;
    private static boolean[] alpha;
    private static char[] arr = {'a','n','t','i', 'c'};
    private static String[] words;
    private static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        alpha = new boolean[26];
        for(char c : arr){
            alpha[c-'a'] = true;
        }
        
        words = new String[N];
        for(int i=0; i<N; i++){
            String word = br.readLine();
            words[i] = word.substring(4,word.length()-4);
        }

        backtracking(0,0);
        System.out.println(max);
    }

    public static void backtracking(int k, int count){
        if(count==K-5){
            max = Math.max(max, check());
            return;
        }
        
        for(int i=k; i<26; i++){
            if(alpha[i]) continue;
            alpha[i]=true;
            backtracking(i+1,count+1);
            alpha[i]=false;
        }
    }

    public static int check(){
        int count=0;
        for(String word : words){
            boolean flag=true;
            for(int i=0; i<word.length(); i++){
                if(!alpha[word.charAt(i)-'a']){
                    flag=false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        return count;
    }
}
