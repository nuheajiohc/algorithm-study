import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String word = br.readLine();
            if(word.length()<M) continue;
            map.put(word, map.getOrDefault(word,0)+1);
        }
        
        List<Word> list= new ArrayList<>();
        for(String word : map.keySet()){
            list.add(new Word(word,map.get(word)));
        }

        list.sort((a,b)->{
            if(a.count==b.count){
                if(a.word.length() == b.word.length()){
                    return a.word.compareTo(b.word);
                }
                return b.word.length()-a.word.length();
            }
            return b.count-a.count;
        });

        StringBuilder sb =new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i).word).append("\n");
        }
        System.out.println(sb);
        
    }

    public static class Word{
        String word;
        int count;

        Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
}
