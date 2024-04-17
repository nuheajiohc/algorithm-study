import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a=0;
        int b=1;
        for(int i=2; i<=N; i++){
            int temp=b;
            b+=a;
            a=temp;
        }
        System.out.println(b);
    }
}
