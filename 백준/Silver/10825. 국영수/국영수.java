import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, korean, math, english);
        }

        Arrays.sort(students);
        StringBuilder sb = new StringBuilder();
        for(Student student : students){
            sb.append(student.name).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static class Student implements Comparable<Student>{
        String name;
        int korean;
        int math;
        int english;

        Student(String name,int korean,int math,int english){
            this.name = name;
            this.korean = korean;
            this.math = math;
            this.english = english;
        }

        public int compareTo(Student another){
            if(korean!=another.korean){
                return another.korean-korean;
            }else if(english!=another.english){
                return english-another.english;
            }else if(math!=another.math){
                return another.math-math;
            }else{
                return name.compareTo(another.name);
            }
        }
    }
}
