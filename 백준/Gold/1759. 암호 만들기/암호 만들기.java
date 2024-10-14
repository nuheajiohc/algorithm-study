import java.io.*;
import java.util.*;

public class Main {

    private static int L,C;
    private static String[] alpha;
    private static StringBuilder sb = new StringBuilder();
    private static String[] arr;
    private static String[] mos = {"a","e","i","o","u"};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new String[C];
        arr = new String[L];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            alpha[i] = st.nextToken();
        }
        Arrays.sort(alpha);

        btk(0,0,0,0);
        System.out.println(sb);
    }

    public static void btk(int depth, int k, int ja, int mo){
        if(depth==L){
            if(ja>=2 && mo>=1){
                for(String letter: arr){
                    sb.append(letter);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=k; i<C; i++){
            arr[depth] = alpha[i];
            if(isMo(alpha[i])) btk(depth+1, i+1, ja, mo+1);
            else btk(depth+1, i+1, ja+1, mo);
        }
    }

    public static boolean isMo(String letter){
        for(String mo : mos){
            if(mo.equals(letter)) return true;
        }
        return false;
    }
}
