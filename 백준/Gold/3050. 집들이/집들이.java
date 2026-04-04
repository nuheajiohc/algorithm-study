import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static int[][] area;
    static int maxPerson = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[] height = new int[C];

        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                if(line.charAt(j)=='.'){
                    height[j]++;
                }else{
                    height[j]=0;
                }
            }

            maxPerson = Math.max(maxPerson, cal(height));
        }
        
        System.out.println(maxPerson);
    }   

    static int cal(int[] height){
        Deque<Integer> stack = new ArrayDeque<>();

        int person = 0;
        for(int i=0; i<=C; i++){
            int currentH = (i==C) ? 0 : height[i];

            while(!stack.isEmpty() && height[stack.peekLast()] > currentH){
                int hIdx = stack.pollLast();
                int h = height[hIdx];

                int w = stack.isEmpty() ? i : i - stack.peekLast() - 1;

                person = Math.max(person, w*2 + h*2 -1);
            }
            stack.offerLast(i);
        }
        return person;
    }
}
