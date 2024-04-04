import java.io.*;
import java.util.*;

public class Main {

    private static int[] alpha;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int count=0;
        String str = br.readLine();
        int[] alphabet = new int[26];
        for(int i=0; i<P; i++){
            alphabet[str.charAt(i)-'A']++;
        }
        st =new StringTokenizer(br.readLine());
        int[] partStr = new int[4];
        for(int i=0; i<4; i++){
            partStr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = P-1;
        while(end<S){
            if(start>0){
                alphabet[str.charAt(start-1)-'A']--;
                alphabet[str.charAt(end)-'A']++;
            }
            if(alphabet['A'-'A']>=partStr[0] && alphabet['C'-'A']>=partStr[1] && alphabet['G'-'A']>=partStr[2] && alphabet['T'-'A']>=partStr[3]){
                count++;
            }
            start++;
            end++;
        }
        System.out.println(count);
    }
}
