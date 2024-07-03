import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line="";
        List<String> words = new ArrayList<>();
        while((line=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line);
            while(st.hasMoreTokens()){
                words.add(st.nextToken());
            }
        }

        StringBuilder wholeSentence = new StringBuilder();
        int len=0;
        for(String word :words){
            if(word.equals("<br>")){
                wholeSentence.append("\n");
                len=0;
                continue;
            }
            if(word.equals("<hr>")){
                if(len!=0) wholeSentence.append("\n");
                wholeSentence.append("--------------------------------------------------------------------------------\n");
                len=0;
                continue;
            }

            if(len+1+word.length()>80){
                len=0;
                wholeSentence.append("\n");
            }
            if(len!=0) wholeSentence.append(" ");
            wholeSentence.append(word);
            len+=word.length()+1;
        }
        System.out.println(wholeSentence.toString());
    }
}
