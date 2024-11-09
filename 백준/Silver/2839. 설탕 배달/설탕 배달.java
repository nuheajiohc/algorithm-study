import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int max = N/3;

        int count=-1;
        for(int i=0; i<=max; i++){
            int temp = N-(3*i);
            if(temp%5==0){
                count= i+(temp/5);
                break;
            }
        }
        System.out.println(count);
    }
}
