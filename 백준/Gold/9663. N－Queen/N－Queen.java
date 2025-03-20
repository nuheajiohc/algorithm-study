import java.io.*;

public class Main {

    private static int N;
    private static boolean[] visY;
    private static boolean[] visXYU;
    private static boolean[] visXYD;
    private static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visY = new boolean[N];
        visXYU = new boolean[2*N-1];
        visXYD = new boolean[2*N-1];

        backtracking(0);
        System.out.println(count);
    }

    public static void backtracking(int row){
        if(row==N){
            count++;
            return;
        }

        for(int col = 0; col <N; col++){
            if(!visY[col] && !visXYU[row+col] && !visXYD[row-col+N-1]){
                visY[col] = true;
                visXYU[row + col] = true;
                visXYD[row - col + N - 1] = true;

                backtracking(row + 1);

                visY[col] = false;
                visXYU[row + col] = false;
                visXYD[row - col + N - 1] = false;
            }
        }
    }
}
