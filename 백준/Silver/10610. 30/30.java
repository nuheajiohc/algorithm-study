import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[10];
        int sum =0;
        boolean hasZero=false;
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'0']++;
            if(s.charAt(i)=='0') hasZero=true;
            sum+=s.charAt(i)-'0';
            sum%=3;
        }
        
        if(sum==0 && hasZero){
            StringBuilder sb = new StringBuilder();
            for(int i=9; i>=0; i--){
                for(int j=0; j<arr[i]; j++){
                    sb.append(i);
                }
            }
            System.out.println(sb.toString());
        }else{
            System.out.println(-1);
        }

    }
}
