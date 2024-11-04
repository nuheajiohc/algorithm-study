import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        boolean[] check = new boolean[S.length()];
        int zero = 0;
        int one = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='0') zero++;
            else one++;
        }

        int count=0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='1'){
                check[i] = true;
                count++;
                if(one/2 == count){
                    break;
                }
            }
        }

        count =0;
        for(int i=S.length()-1; i>=0; i--){
            if(S.charAt(i)=='0'){
                check[i] = true;
                count++;
                if(zero/2 == count){
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<S.length(); i++){
            if(!check[i]){
                sb.append(S.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
