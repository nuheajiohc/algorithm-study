import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int person = 0;
        int zeroCount = 0;
        int oneCount = 0;
        int round = 2;
        boolean isAnswer = false;
        while(true){
            for(int i =0; i<2; i++){
                zeroCount++;
                if(target==0 && zeroCount==T){
                    isAnswer = true;
                    break;
                }
                person++;

                oneCount++;
                if(target==1 && oneCount==T){
                    isAnswer = true;
                    break;
                }
                person++;
            }
            if(isAnswer) break;
            for(int i=0; i<round; i++){
                zeroCount++;
                if(target==0 && zeroCount==T){
                    isAnswer = true;
                    break;
                }
                person++;
            }
            if(isAnswer) break;
            for(int i=0; i<round; i++){
                oneCount++;
                if(target==1 && oneCount==T){
                    isAnswer = true;
                    break;
                }
                person++;
            }
            if(isAnswer) break;
            round++;
        }
        System.out.println(person%A);
    }
}