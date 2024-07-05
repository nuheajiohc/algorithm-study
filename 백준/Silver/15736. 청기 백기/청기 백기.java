import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cur = 1;
        int count=0;
        while(cur*cur<=N){
            count++;
            cur++;
        }
        System.out.println(count);
    }
}
