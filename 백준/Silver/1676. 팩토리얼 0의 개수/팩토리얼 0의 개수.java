import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count1=0;
        int count2=0;
        while(N>0){
            int temp = N;
            while(true){
                if(temp%2==0){
                    count1++;
                    temp/=2;
                }else if(temp%5==0){
                    count2++;
                    temp/=5;
                }else{
                    break;   
                }
            }
            N--;
        }
        System.out.println(Math.min(count1,count2));
    }
}
