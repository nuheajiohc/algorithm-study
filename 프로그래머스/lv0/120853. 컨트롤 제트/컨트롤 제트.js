function solution(s) {
    const answer = s.split(" ").reduce((acc,cur,i,arr)=>{
        if(cur==="Z"){
            acc-=arr[i-1];
            return acc;
        }
        acc+=Number(cur);
        return acc;
    },0)
    return answer;
}