import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i=0;
        int count=666;
        while(N>i){
            if(String.valueOf(count).contains("666")){
                i++;
            }
            count++;
        }
        System.out.println(count-1);
    }
}
