import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            String[] sounds = br.readLine().split(" ");
            while(true){
                String line = br.readLine();
                if(line.equals("what does the fox say?")){
                    for(String sound : sounds){
                        if(sound.isEmpty()) continue;
                        sb.append(sound).append(" ");
                    }
                    sb.append("\n");
                    break;
                }
                String animalSound = line.split(" goes ")[1];
                for(int i=0; i<sounds.length; i++){
                    if(sounds[i].equals(animalSound)) sounds[i]="";
                }
            }
        }
        System.out.println(sb.toString());
    }
}
