import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
    	
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	BigInteger a = new BigInteger(st.nextToken());
        	BigInteger b = new BigInteger(st.nextToken());
        	
        	sb.append("#").append(t).append(" ").append(a.add(b)).append("\n");
        }
        System.out.println(sb);
    }
}