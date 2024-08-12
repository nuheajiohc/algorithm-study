import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] preference = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            preference[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[n];
        int[] ldp = new int[n];
        prefix[0] = preference[0];
        ldp[0] = prefix[0];
        for(int i=1; i<n; i++){
            prefix[i] = Math.max(preference[i],prefix[i-1]+preference[i]);
        }
        for(int i=1; i<n; i++){
            ldp[i] = Math.max(ldp[i-1],prefix[i]);
        }

        int[] rdp = new int[n];
        int[] sufix = new int[n];
        rdp[n-1] = preference[n-1];
        sufix[n-1] = rdp[n-1];
        for(int i=n-2; i>=0; i--){
            sufix[i] = Math.max(preference[i],preference[i]+sufix[i+1]);
        }
        for(int i=n-2; i>=0; i--){
            rdp[i] = Math.max(rdp[i+1],sufix[i]);
        }

        int maxValue=-100000000;
        for(int i=1; i<n-1; i++){
            maxValue = Math.max(maxValue, ldp[i-1]+rdp[i+1]);
        }
        System.out.println(maxValue);
    }
}
