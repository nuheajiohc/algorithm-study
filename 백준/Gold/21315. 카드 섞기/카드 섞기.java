import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] target;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        target = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }

        for(int k=1; Math.pow(2,k)<N; k++){
            for(int kk=1; Math.pow(2,kk)<N; kk++){
                int[] cards = new int[N];
                for(int i=0; i<N; i++){
                    cards[i] = i+1;
                }
                shuffle(k,cards);
                shuffle(kk,cards);

                if(isAnswer(cards)){
                    System.out.println(k+" "+kk);
                    return;
                }
            }
        }
    }

    public static boolean isAnswer(int[] cards){
        for(int i=0; i<N; i++){
            if(cards[i] != target[i]) return false;
        }
        return true;
    }

    public static void shuffle(int k, int[] cards){
        int last = N;
        int range;
        for(int i=1; i<=k+1; i++){
            range = (int)Math.pow(2, k-i+1);

            List<Integer> tmp = new ArrayList<>();
            for(int j = last-range; j< last; j++){
                tmp.add(cards[j]);
                cards[j] = 0;
            }

            for(int j=0; j<N; j++){
                if(cards[j] != 0){
                    tmp.add(cards[j]);
                }
                cards[j] = tmp.get(j);
            }

            last = range;
        }
    }
}
