import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        BigInteger hashValue=BigInteger.ZERO;
        for(int i=0; i<L; i++){
            long num = str.charAt(i) - 'a'+1;
            BigInteger r=BigInteger.ONE;
            for(int j=1; j<=i; j++){
                r = r.multiply(BigInteger.valueOf(31));
            }
            hashValue = hashValue.add((r.multiply(BigInteger.valueOf(num)))).remainder(BigInteger.valueOf(1234567891));
        }
        System.out.println(hashValue);
    }
}
