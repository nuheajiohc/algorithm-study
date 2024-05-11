import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int hashValue=0;
        for(int i=0; i<L; i++){
            long num = str.charAt(i) - 'a'+1;
            long r=1;
            for(int j=1; j<=i; j++){
                r*=31;
            }
            hashValue += (num*r)%1234567891;
        }
        System.out.println(hashValue);
    }
}
