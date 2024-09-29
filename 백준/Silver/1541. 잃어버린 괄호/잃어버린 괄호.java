import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    String[] arr =line.split("-");

    int sum=0;
    for(int i=0;i<arr.length;i++){
      String[] temp =  arr[i].split("\\+");
      int tempSum=0;
      for(String num : temp){
        tempSum+=Integer.parseInt(num);
      }

      if(i==0) sum+=tempSum;
      else sum-=tempSum;
    }
    System.out.println(sum);
  }
}
