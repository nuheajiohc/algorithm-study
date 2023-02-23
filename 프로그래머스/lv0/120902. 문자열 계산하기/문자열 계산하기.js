function solution(my_string) {
    let sign=1
    const answer=my_string.split(" ").reduce((acc,cur,idx,arr)=>{
        if(cur==="+"){
            sign=1;
        }else if(cur==="-"){
            sign=-1;
        }else{
            acc+=cur*sign;
        }
        return acc;
    },0)
    return answer;
}