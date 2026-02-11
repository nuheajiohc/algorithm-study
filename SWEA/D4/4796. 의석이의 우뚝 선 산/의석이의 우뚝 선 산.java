import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		
		st.nextToken(); 
        int TC = (int) st.nval;
        
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			st.nextToken();
            int N = (int) st.nval;
            
            int[] mt = new int[N];
            for (int i = 0; i < N; i++) {
                st.nextToken();
                mt[i] = (int) st.nval;
            }
			
			int total = 0;
			
			for(int i=1; i<N-1; i++) {
				if(mt[i-1]< mt[i] && mt[i]>mt[i+1]) {
					
					int idx = i;
					int left = 0;
					while(idx>0) {
						if(mt[idx] > mt[idx-1]) {
							left++;
							idx--;
						}else {
							break;
						}
					}
					
					idx = i;
					int right = 0;
					while(idx<N-1) {
						if(mt[idx] > mt[idx+1]) {
							right++;
							idx++;
						}else {
							break;
						}
					}
					total += left*right;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(total).append("\n");
		}
		System.out.println(sb);
			
	}

}
