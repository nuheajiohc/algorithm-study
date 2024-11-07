import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='a') count++;
        }
        int b=0;
        for(int i=0; i<count; i++){
            if(str.charAt(i)=='b') b++;
        }

        int min=b;
        for(int i=1; i<str.length(); i++){
            if(str.charAt((i+count-1)%str.length())=='b')b++;
            if(str.charAt(i-1)=='b') b--;
            min = Math.min(min, b);
        }
        System.out.println(min);
    }
}
