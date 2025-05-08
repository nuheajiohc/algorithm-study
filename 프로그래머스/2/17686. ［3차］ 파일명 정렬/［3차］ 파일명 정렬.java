import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        List<FileInfo> fileInfos = new ArrayList<>();
        for(String file : files){
            int firstNum = findFirstNum(file);
            int lastNum = findLastNum(file, firstNum);
            fileInfos.add(new FileInfo(file, file.substring(0,firstNum), file.substring(firstNum, lastNum)));
        }
        
        Collections.sort(fileInfos);
        String[] answer = new String[fileInfos.size()];
        for(int i=0; i<fileInfos.size(); i++){
            answer[i] = fileInfos.get(i).name;
        }
        
        return answer;
    }
    
    private int findFirstNum(String file){
        for(int i=0; i<file.length(); i++){
            if(Character.isDigit(file.charAt(i))){
                return i;
            }
        }
        return -1;
    }
    
    private int findLastNum(String file, int firstIdx){
        for(int i=firstIdx; i<file.length(); i++){
            if(!Character.isDigit(file.charAt(i))){
                return i;
            }
        }
        return file.length();
    }
    
    class FileInfo implements Comparable<FileInfo>{
        String name;
        String head;
        int number;
        
        FileInfo(String name, String head, String number){
            this.name = name;
            this.head = head.toLowerCase();
            this.number = Integer.valueOf(number);
        }
        
        public int compareTo(FileInfo f){
            if(this.head.equals(f.head)){
                return this.number-f.number;
            }else{
                return this.head.compareTo(f.head);
            }
        }
    }
}