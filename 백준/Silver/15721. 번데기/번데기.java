import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int round = 1;
        int zero = 0;
        int one = 0;
        
        int idx = -1;
        boolean isEnd=false;
        while(true){
            idx = (idx+1)%A;
            zero++;
            if(target==0 && zero==T){
                break;
            }

            idx = (idx+1)%A;
            one++;
            if(target==1 && one==T){
                break;
            }

            idx = (idx+1)%A;
            zero++;
            if(target==0 && zero==T){
                break;
            }

            idx = (idx+1)%A;
            one++;
            if(target==1 && one==T){
                break;
            }

            for(int i=0; i<round+1; i++){
                idx = (idx+1)%A;
                zero++;
                if(target==0 && zero==T){
                    isEnd=true;
                    break;
                }
            }
            if(isEnd) break;

            for(int i=0; i<round+1; i++){
                idx = (idx+1)%A;
                one++;
                if(target==1 && one==T){
                    isEnd=true;
                    break;
                }                
            }
            if(isEnd) break;
            round++;
        }
        System.out.println(idx);
    }
}
