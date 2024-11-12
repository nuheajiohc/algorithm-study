import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dice = new int[N][6];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < 6; i++) {
            int ceil = dice[0][i];
            int tempMax = calMaxDice(dice[0], i);
            for (int j = 1; j < N; j++) {
                for (int k = 0; k < 6; k++) {
                    if (dice[j][k] == ceil) {
                        if(k==0){
                            ceil = dice[j][5];
                        }else if(k==1){
                            ceil = dice[j][3];
                        }else if(k==2){
                            ceil = dice[j][4];
                        }else if(k==3){
                            ceil = dice[j][1];
                        }else if(k==4){
                            ceil = dice[j][2];
                        }else{
                            ceil = dice[j][0];
                        }
                        tempMax += calMaxDice(dice[j],k);
                        break;
                    }
                }
            }
            max = Math.max(max, tempMax);
        }
        System.out.println(max);
    }

    public static int calMaxDice(int[] dice, int idx) {
        int tempMax = 0;
        if (idx == 0 || idx == 5) {
            for (int i = 1; i < 5; i++) {
                tempMax = Math.max(tempMax, dice[i]);
            }
        } else if (idx == 1 || idx == 3) {
            for (int i = 0; i < 6; i++) {
                if (i == 1 || i == 3) continue;
                tempMax = Math.max(tempMax, dice[i]);
            }
        } else {
            for (int i = 0; i < 6; i++) {
                if (i == 2 || i == 4) continue;
                tempMax = Math.max(tempMax, dice[i]);
            }
        }
        return tempMax;
    }
}
