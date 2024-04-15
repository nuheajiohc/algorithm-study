import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count=0;
        while(N>=0){
            if(N%5==0){
                count += N/5;
                System.out.println(count);
                return;
            }else{
                count++;
                N-=3;
            }
        }
        System.out.println(-1);
    }
}
