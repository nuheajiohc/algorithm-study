import java.io.*;
import java.util.*;

public class Main {

    private static int L,C;
    private static char[] alphabet,check;
    private static Set<Character> vowel = new HashSet<>(List.of('a','e','i','o','u'));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        check = new char[L];
        st= new StringTokenizer(br.readLine());
        alphabet = new char[C];
        for(int i=0; i<C; i++){
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);

        backtracking(0,0,0,0);
        System.out.println(sb.toString());
    }

    public static void backtracking(int k, int depth,int vowelCount, int consCount){
        if(depth == L){
            if(vowelCount>0 && consCount>1){
                for(char c: check){
                    sb.append(c);
                }
                sb.append('\n');
            }
            return;
        }

        for(int i=k; i<C; i++){
            check[depth] = alphabet[i];
            if(vowel.contains(alphabet[i])){
                backtracking(i+1,depth+1,vowelCount+1,consCount);
            }else{
                backtracking(i+1,depth+1,vowelCount,consCount+1);
            }
        }
    }
}
