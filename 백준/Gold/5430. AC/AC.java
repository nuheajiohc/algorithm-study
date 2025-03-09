import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            String commands = br.readLine();
            int length = Integer.parseInt(br.readLine());
            String rawArr = br.readLine();
            String[] arr = convertToArr(rawArr, length);

            int st=0;
            int en=length-1;
            int count=0;
            boolean isFront=true;
            for(int j=0; j<commands.length(); j++){
                char command = commands.charAt(j);
                if(command == 'R'){
                    isFront=!isFront;
                }else{
                    if(isFront){
                        st+=1;
                    }else{
                        en-=1;
                    }
                    count++;
                }
            }

            if(count>length){
                sb.append("error").append("\n");
            }else{
                StringBuilder tmp = new StringBuilder();
                sb.append("[");

                if(isFront){
                    for(int j=st; j<=en; j++){
                        tmp.append(arr[j]).append(",");
                    }
                }else{
                    for(int j=en; j>=st; j--){
                        tmp.append(arr[j]).append(",");
                    }
                }

                if(tmp.length()>0){
                    tmp.deleteCharAt(tmp.length()-1);
                }
                
                sb.append(tmp);
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static String[] convertToArr(String str, int length){
        String unwrappedStr = str.substring(1,str.length()-1);
        if(length==0){
            return new String[0];
        }else if(length==1){
            return new String[]{unwrappedStr};
        }else{
            return unwrappedStr.split(",");

        }
    }
}
