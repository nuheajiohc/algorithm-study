import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] serialNumber = new String[N];
        for(int i=0; i<N; i++){
            serialNumber[i] = br.readLine();
        }

        Arrays.sort(serialNumber,(a,b)->{
            if(a.length()!=b.length()){
                return a.length()-b.length();
            }else{
                int aSum=0;
                int bSum=0;
                for(int i=0; i<a.length(); i++){
                    if(a.charAt(i)>='0' && a.charAt(i)<='9'){
                        aSum += a.charAt(i)-'0';
                    }
                    if(b.charAt(i)>='0' && b.charAt(i)<='9'){
                        bSum += b.charAt(i)-'0';
                    }
                }
                if(aSum!=bSum){
                    return aSum-bSum;
                }else{
                    for(int i=0; i<a.length(); i++){
                        if(a.charAt(i)!=b.charAt(i)){
                            return a.charAt(i)-b.charAt(i);
                        }else{
                            continue;
                        }
                    }
                    return 0;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(serialNumber[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
