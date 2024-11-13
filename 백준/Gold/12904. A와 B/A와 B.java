import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        if(isChanged(A,new StringBuilder(B))){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    public static boolean isChanged(String A, StringBuilder B){
        if(A.length()==B.length()){
            return A.equals(B.toString());
        }
        char c = B.charAt(B.length()-1);
        B.deleteCharAt(B.length()-1);
        if(c=='A'){
            return isChanged(A,B);
        }else{
            return isChanged(A,B.reverse());
        }
    }
}
