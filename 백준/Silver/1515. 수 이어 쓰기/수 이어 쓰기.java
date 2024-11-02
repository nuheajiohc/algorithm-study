import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        int count=0;
        int idx=0;
        while(idx!=number.length()){
            count++;
            String str = String.valueOf(count);
            for(int i=0; i<str.length(); i++){
                if(idx<number.length() && number.charAt(idx)==str.charAt(i)){
                    idx++;
                }
            }
        }
        System.out.println(count);

    }
}
