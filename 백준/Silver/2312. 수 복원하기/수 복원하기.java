import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int i = 2;
            int count = 0;
            while(true){
                if(N%i==0){
                    count++;
                    N/=i;
                }else{
                    if(count>0){
                        sb.append(i).append(" ").append(count).append("\n");
                    }
                    i++;
                    count=0;
                    if(N==1) break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
