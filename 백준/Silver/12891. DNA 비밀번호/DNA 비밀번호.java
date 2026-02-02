import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char[] DNA = br.readLine().toCharArray();
	
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<P-1; i++) {
			if(DNA[i]=='A') A--;
			else if(DNA[i]=='C') C--;
			else if(DNA[i]=='G') G--;
			else T--;
		}
		
		int count=0;
		
		for(int i=0; i<=S-P; i++) {
			if(DNA[i+P-1]=='A') A--;
			else if(DNA[i+P-1]=='C') C--;
			else if(DNA[i+P-1]=='G') G--;
			else T--;
			
			if(A<=0 && C<=0 && G<=0 && T<=0) {
				count++;
			}
			
			if(DNA[i]=='A') A++;
			else if(DNA[i]=='C') C++;
			else if(DNA[i]=='G') G++;
			else T++;
		}
		System.out.println(count);
	}
}
