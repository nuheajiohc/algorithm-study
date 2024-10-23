import java.io.*;
import java.util.*;

class Solution{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
		for(int test_case=1; test_case<=T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double sum=0;
            while(st.hasMoreTokens()){
	            sum += Integer.parseInt(st.nextToken());
            }
            
            String answer = String.format("#%d %.0f%n", test_case, sum/10);
            sb.append(answer);
        }
    
        System.out.println(sb);
    }
}