import java.io.*;

public class Main {

    static String word;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        used = new boolean[word.length()];
        recur(0,word.length());
        System.out.println(sb.toString());
    }

    public static void recur(int s,int e){
        if(s==e) return;
        int minIdx=s;
        for(int i=s; i<e; i++){
            if(used[i]) continue;
            if(word.charAt(minIdx)>word.charAt(i)){
                minIdx=i;
            }
        }
        used[minIdx]=true;
        sb.append(makeWord()).append("\n");
        recur(minIdx+1,e);
        recur(s,minIdx);
    }

    public static String makeWord(){
        StringBuilder sbd = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            if(used[i]){
                sbd.append(Character.toString(word.charAt(i)));
            }
        }
        return sbd.toString();
    }
}
