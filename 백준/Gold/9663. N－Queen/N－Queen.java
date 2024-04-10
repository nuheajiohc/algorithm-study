import java.io.*;

public class Main {

    private static boolean[] visY,visXY,visYX;
    private static int N;
    private static int answer;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visY = new boolean[N];
        visXY = new boolean[2*N-1];
        visYX = new boolean[2*N-1];
        backtracking(0);
        System.out.println(answer);
    }

    public static void backtracking(int x){
        if(x==N){
            answer++;
            return;
        }

        for(int j=0; j<N; j++){
            if(visY[j] || visXY[x-j+N-1] || visYX[x+j]) continue;
                visY[j] = true;
                visXY[x-j+N-1] = true;
                visYX[x+j] = true;
                backtracking(x+1);
                visY[j] = false;
                visXY[x-j+N-1] = false;
                visYX[x+j] = false;
        }
    }
}
