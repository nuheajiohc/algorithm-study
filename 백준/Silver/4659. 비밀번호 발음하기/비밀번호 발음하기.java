import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true){
            String password = br.readLine();
            if(password.equals("end")) break;
            if(isAcceptable(password)){
                sb.append(String.format("<%s> is acceptable.",password));
            }else{
                sb.append(String.format("<%s> is not acceptable.",password));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isAcceptable(String password){
        return includeVowel(password) && !isAdjacent(password) && !isSame(password);
    }

    public static boolean includeVowel(String password){
        for(int i=0; i<password.length(); i++){
            char c = password.charAt(i);
            if(isVowel(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o'|| c=='u';
    }

    public static boolean isCons(char c){
        return !isVowel(c);
    }

    public static boolean isAdjacent(String password){
        for(int i=0; i<=password.length()-3; i++){
            char a = password.charAt(i);
            char b = password.charAt(i+1);
            char c = password.charAt(i+2);
            if(isVowel(a) && isVowel(b) && isVowel(c)){
                return true;
            }
            if(isCons(a) && isCons(b) && isCons(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean isSame(String password){
        for(int i=0; i<=password.length()-2; i++){
            char a = password.charAt(i);
            char b = password.charAt(i+1);
            if(a==b && a!='e'&& a!='o'){
                return true;
            }
        }
        return false;
    }
}
