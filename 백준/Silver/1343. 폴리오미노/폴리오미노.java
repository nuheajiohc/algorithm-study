import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int count=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='X'){
                count++;
            }
            if(s.charAt(i)=='.'|| i+1==s.length()){
                    if(count/4>0){
                        sb.append("AAAA".repeat(count/4));
                        count%=4;
                    }
                    if(count/2>0){
                        sb.append("BB".repeat(count/2));
                        count%=2;
                    }
                    if(count>0){
                        System.out.println(-1);
                        return;
                    }
                    if(s.charAt(i)=='.') sb.append(".");
            }
        }
        System.out.println(sb.toString());
    }
}
