import java.io.*;
import java.util.*;

public class Main {

    private static String[] keyboard = new String[3];
    private static Set<Character> leftSet = new HashSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        char l = st.nextToken().toCharArray()[0];
        char r = st.nextToken().toCharArray()[0];
        String target = br.readLine();

        keyboard[0] = "qwertyuiop";
        keyboard[1] = "asdfghjkl";
        keyboard[2] = "zxcvbnm";

        String leftAlpha = "qwertasdfgzxcv";
        for(int i=0; i<leftAlpha.length(); i++){
            leftSet.add(leftAlpha.charAt(i));
        }
        
        int minimum = 0;
        for(int i=0; i<target.length(); i++){
            minimum ++;
            char c = target.charAt(i);
            if(possibleLeft(c)){
                minimum += getDistance(l, c);
                l = c;
            }else{
                minimum += getDistance(r, c);
                r = c;
            }
        }
        System.out.println(minimum);
    }

    public static boolean possibleLeft(char c){
        return leftSet.contains(c);
    }

    public static int getDistance(char c1, char c2){
        int x1=0;
        int y1=0;
        int x2=0;
        int y2=0;

        for(int i=0; i<3; i++){
            for(int j=0; j<keyboard[i].length(); j++){
                if(keyboard[i].charAt(j)==c1){
                    x1 = i;
                    y1 = j;
                }
                
                if(keyboard[i].charAt(j)==c2){
                    x2 = i;
                    y2 = j;
                }
            }
        }
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}
