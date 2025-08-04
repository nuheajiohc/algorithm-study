import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] dna = new String[N];
        for(int i=0; i<N; i++){
            dna[i] = br.readLine();
        }

        int count=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int A=0;
            int C=0;
            int G=0;
            int T=0;
            for(int j=0; j<N; j++){
                switch(dna[j].charAt(i)){
                    case 'A':
                        A++;
                        break;
                    case 'C':
                        C++;
                        break;
                    case 'G':
                        G++;
                        break;
                    case 'T':
                        T++;
                        break;
                }
            }
            
            if(A>=C && A>=G && A>=T){
                sb.append("A");
                count += N-A;
            }else if(C>=A && C>=G && C>=T){
                sb.append("C");
                count += N-C;
            }else if(G>=A && G>=C && G>=T){
                sb.append("G");
                count += N-G;
            }else if(T>=A && T>=C && T>=G){
                sb.append("T");
                count += N-T;
            }
        }
        System.out.println(sb.toString());
        System.out.println(count);
    }
    
}
