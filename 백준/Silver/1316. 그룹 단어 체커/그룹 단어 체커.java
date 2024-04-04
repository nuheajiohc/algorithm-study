import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count=N;
        for(int i=0; i<N; i++){
            String word = br.readLine();
            int[] alphabet = new int[26];
            alphabet[word.charAt(0)-'a']=1;
            for(int j=1; j<word.length(); j++){
                int prev = word.charAt(j-1)-'a';
                int cur = word.charAt(j)-'a';
                if(prev==cur){
                    alphabet[cur]++;
                }else{
                    if(alphabet[cur]>0){
                        count--;
                        break;
                    }else{
                        alphabet[cur]++;
                    }
                }
            }

        }
        System.out.println(count);
    }
}
