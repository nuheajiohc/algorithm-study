import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        int idx = 0;
        for(int n=1; ; n++){
            String s = String.valueOf(n);
            for(int i=0; i<s.length() && idx<num.length(); i++){
                if(s.charAt(i)== num.charAt(idx)){
                    idx++;
                }
            }

            if(idx == num.length()){
                System.out.println(n);
                break;
            }
        }
    }
}
