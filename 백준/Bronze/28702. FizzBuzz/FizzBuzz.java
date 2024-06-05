import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target=0;
        for(int i=1;i<=3; i++){
            String line = br.readLine();
            if(line.charAt(0)-'0'>=1 && line.charAt(0)-'0'<=9){
                target = Integer.parseInt(line)+4-i;
                break;
            }
        }

        if(target%15==0){
            System.out.println("FizzBuzz");
        }else if(target%3==0){
            System.out.println("Fizz");
        }else if(target%5==0){
            System.out.println("Buzz");
        }else{
            System.out.println(target);
        }
    }
}
