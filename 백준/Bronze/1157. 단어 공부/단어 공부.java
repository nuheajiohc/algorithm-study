import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine().toUpperCase();

    int[] alpha = new int[26];
    for(int i=0; i<line.length(); i++){
      alpha[line.charAt(i)-'A']++;
    }

    int maxCount=0;
    int maxIndex=0;
    for(int i=0; i<26; i++){
      if(alpha[i]>alpha[maxIndex]){
        maxCount = 1;
        maxIndex = i;
      }else if(alpha[i]==alpha[maxIndex]){
        maxCount++;
      }
    }

    if(maxCount>1){
      System.out.println("?");
    }else{
      System.out.println((char)('A'+maxIndex));
    }
  }
}
