import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)>='a' && word.charAt(i)<='z'){
                sb.append((char)(word.charAt(i)-32));
            }else{
                sb.append((char)(word.charAt(i)+32));
            }
        }
        System.out.println(sb.toString());
    }
}
