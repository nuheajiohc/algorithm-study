import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        if(isJava(sentence)){
            System.out.println(changeToCpp(sentence));
        }else if(isCpp(sentence)){
            System.out.println(changeToJava(sentence));
        }else{
            System.out.println("Error!");
        }

    }

    public static boolean isJava(String str){
        if(!(str.charAt(0)>='a' && str.charAt(0)<='z')){
            return false;
        }

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i)=='_'){
                return false;
            }
        }
        return true;
    }

    public static String changeToCpp(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                sb.append("_").append(String.valueOf((char)(str.charAt(i)+32)));

            }else{
                sb.append(String.valueOf(str.charAt(i)));
            }
        }
        return sb.toString();
    }

    public static boolean isCpp(String str){
        if(str.charAt(0)=='_' || str.charAt(str.length()-1)=='_') return false;
        if(!(str.charAt(0)>='a' && str.charAt(0)<='z')){
            return false;
        }

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i)=='_' && str.charAt(i+1)=='_'){
                return false;
            }
            if(str.charAt(i)<='Z' && str.charAt(i)>='A'){
                return false;
            }
        }
        return true;
    }

    public static String changeToJava(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i-1)=='_'){
                sb.append((char)(str.charAt(i)-32));
            }else if(str.charAt(i)=='_'){
                continue;
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
