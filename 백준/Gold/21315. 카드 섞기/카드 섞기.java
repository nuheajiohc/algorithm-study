import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; (1<<i)<N; i++){
            for(int j=1; (1<<j)<N; j++){
                LinkedList<Integer> cand = generateCard();
                shuffle(cand, i);
                shuffle(cand, j);

                if(isSame(arr, cand)){
                    System.out.println(i+ " " +j);
                    return;
                }
            }
        }
    }

    public static void shuffle(LinkedList<Integer> cand, int k){
        int target = 1<<k;

        LinkedList<Integer> temp = new LinkedList<>();
        for(int i=0; i<target; i++){
            int value = cand.removeLast();
            temp.addFirst(value);
        }

        for(int i=2; i<=k+1; i++){
            target = 1<<(k-i+1);
            for(int j=0; j<target; j++){
                int value = temp.removeLast();
                temp.addFirst(value);
            }

            int size = temp.size();
            for(int j=0; j<size-target; j++){
                int value = temp.removeLast();
                cand.addFirst(value);
            }
        }

        while(!temp.isEmpty()){
                cand.addFirst(temp.removeLast());
        }
    }

    public static LinkedList<Integer> generateCard(){
        LinkedList<Integer> cand = new LinkedList<>();
        for(int i=0; i<N; i++){
            cand.add(i+1);
        }
        return cand;
    }

    public static boolean isSame(int[] target, List<Integer> cand){
        for(int i=0; i<N; i++){
            if(target[i] != cand.get(i)){
                return false;
            }
        }
        return true;
    }
}
