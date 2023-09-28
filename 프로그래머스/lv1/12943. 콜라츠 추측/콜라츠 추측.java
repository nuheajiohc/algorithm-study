class Solution {
    public long solution(int num) {
        long answer = recursion(num,0);
        return answer;
    }
    
    public long recursion(long n, int count){
        if(count>=500){
            return -1;
        }
        if(n==1){
            return count;
        }
        if(n%2==0){
            return recursion(n/2,count+1);
        }else{
            return recursion(n*3+1,count+1);
        }
    }
}