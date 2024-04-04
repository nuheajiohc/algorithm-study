import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] switches = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N;i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int P = Integer.parseInt(br.readLine());
        for(int i=0; i<P; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            if(gender == 1){
                int count=1;
                while(count*pos<=N){
                    switches[count*pos] = switches[count*pos]==1 ? 0 :1;
                    count++;
                }
            }else{
                int count=1;
                switches[pos]=switches[pos]==1?0:1;
                while(pos-count>0 && pos+count<=N){
                    if(switches[pos-count]==switches[pos+count]){ 
                        if(switches[pos-count]==1){
                            switches[pos-count]=0;
                            switches[pos+count]=0;
                        }else{
                            switches[pos-count]=1;
                            switches[pos+count]=1;
                        }
                        count++;
                    }else{
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            sb.append(switches[i]).append(" ");
            if(i%20==0){
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
