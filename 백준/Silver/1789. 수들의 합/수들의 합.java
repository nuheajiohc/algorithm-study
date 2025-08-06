import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long maxValue=1;
        while((1+maxValue) * maxValue / 2 <= S){
            maxValue++;
        }
        System.out.println(maxValue-1);

    }
}
