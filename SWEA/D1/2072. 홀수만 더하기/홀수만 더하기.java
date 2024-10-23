import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
       
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int sum=0;
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(num%2==1){
                    sum+=num;
                }
            }
			sb.append(String.format("#%d %d%n",test_case, sum));
		}
        System.out.println(sb);
	}
}