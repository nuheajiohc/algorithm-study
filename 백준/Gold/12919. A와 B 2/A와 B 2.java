import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        if(isChanged(S,new StringBuilder(T))){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

    public static boolean isChanged(String S, StringBuilder T){
        if(S.length()==T.length()){
            return S.contentEquals(T);
        }

        boolean isSame=false;
        if(T.charAt(T.length()-1)=='A'){
            StringBuilder temp  = new StringBuilder(T);
            isSame = isChanged(S,temp.deleteCharAt(T.length()-1));
        }

        if(!isSame && T.charAt(0)=='B'){
            isSame = isChanged(S,T.deleteCharAt(0).reverse());
        }

        return isSame;
    }
}
