import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String str = br.readLine();
        String replacedInput = input.replace(str,"1");
        int count=0;
        for(int i=0; i<replacedInput.length();i++){
            if(replacedInput.charAt(i)=='1') count++;
        }
        System.out.println(count);
    }
}
