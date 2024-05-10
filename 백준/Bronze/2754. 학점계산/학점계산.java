import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String score = br.readLine();
        double avgScore = 0;
        switch(score){
            case "A+":
                avgScore=4.3;
                break;
            case "A0":
                avgScore=4.0;
                break;
            case "A-":
                avgScore=3.7;
                break;
            case "B+":
                avgScore=3.3;
                break;
            case "B0":
                avgScore=3.0;
                break;
            case "B-":
                avgScore=2.7;
                break;
            case "C+":
                avgScore=2.3;
                break;
            case "C0":
                avgScore=2.0;
                break;
            case "C-":
                avgScore=1.7;
                break;
            case "D+":
                avgScore=1.3;
                break;
            case "D0":
                avgScore=1.0;
                break;
            case "D-":
                avgScore=0.7;
                break;
            default:
                avgScore=0.0;
        }
        System.out.println(avgScore);
    }
}
