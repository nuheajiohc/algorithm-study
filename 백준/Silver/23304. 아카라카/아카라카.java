import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        if(isAkarakaPalindrome(word)){
            System.out.println("AKARAKA");
        }else{
            System.out.println("IPSELENTI");
        }
    }

    public static boolean isAkarakaPalindrome(String word){
        if(word.length()==1) return true;
        String whole = word;
        int len = word.length();
        String head = word.substring(0,len/2);
        String tail = word.substring(len-len/2);
        
        if(isPalindrome(whole) && isPalindrome(head) && isPalindrome(tail)){
            return isAkarakaPalindrome(head);
        }
        return false;
    }

    public static boolean isPalindrome(String s){
        for(int i=0; i<=s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}