import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        int[] ascDp = new int[N];
        int[] descDp = new int[N];
        for(int i=0; i<N; i++){
            ascDp[i]=1;
            for(int j=0; j<i; j++){
                if(sequence[i]>sequence[j]){
                    ascDp[i]= Math.max(ascDp[i],ascDp[j]+1);
                }
            }
        }
        for(int i=N-1; i>=0; i--){
            descDp[i]=1;
            for(int j=i+1; j<N; j++){
                if(sequence[i]>sequence[j]){
                    descDp[i]=Math.max(descDp[i],descDp[j]+1);
                }
            }
        }

        int maxLength=0;
        for(int i=0; i<N; i++){
            maxLength = Math.max(maxLength,ascDp[i]+descDp[i]-1);
        }
        System.out.println(maxLength);
    }
}
