import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] left = new int[26];
	static int[] right = new int[26];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char ro = st.nextToken().charAt(0);
			char le = st.nextToken().charAt(0);
			char ri = st.nextToken().charAt(0);
			if(le=='.') {
				left[ro-'A'] = -1;
			}else if(le!='.') {
				left[ro-'A'] = le - 'A';	
			}
			
			if(ri=='.') {
				right[ro-'A'] = -1;
			}else if(ri!='.') {
				right[ro-'A'] = ri - 'A';
			}
		}
		
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);
		
		System.out.println(sb);
	}
	
	static void preorder(int idx) {
		if(idx==-1) return;
		sb.append((char)('A'+idx));
		
		if(left[idx]!=-1) preorder(left[idx]);
		if(right[idx]!=-1) preorder(right[idx]);
	
	}
	
	static void inorder(int idx) {
		if(idx==-1) return;
		
		if(left[idx]!=-1) inorder(left[idx]);
		sb.append((char)('A'+idx));
		if(right[idx]!=-1) inorder(right[idx]);
	}

	static void postorder(int idx) {
		if(idx==-1) return;
		if(left[idx]!=-1) postorder(left[idx]);
		if(right[idx]!=-1) postorder(right[idx]);
		sb.append((char)('A'+idx));
	}
}
