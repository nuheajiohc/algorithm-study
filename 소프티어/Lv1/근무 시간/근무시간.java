import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalWorkTime = 0;
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String startTime = st.nextToken();
            String endTime = st.nextToken();
            totalWorkTime += getDayWorkTime(startTime, endTime);
        }
        System.out.println(totalWorkTime);
    }

    public static int getDayWorkTime(String startTime, String endTime){
        StringTokenizer st = new StringTokenizer(startTime,":");
        int startTimeToMinute = toMinute(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(endTime,":");
        int endTimeToMinute = toMinute(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        return endTimeToMinute - startTimeToMinute;
    }

    public static int toMinute(int hour, int minute){
        return hour*60 + minute;
    }
}
