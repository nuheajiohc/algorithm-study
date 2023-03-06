function solution(A,B){
    A.sort((a,b)=>a-b);
    B.sort((a,b)=>b-a);
    const answer = A.reduce((acc,cur,idx)=>{
        acc+=cur*B[idx];
        return acc;
    },0)
    return answer;
}