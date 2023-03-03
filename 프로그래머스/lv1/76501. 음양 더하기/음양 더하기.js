function solution(absolutes, signs) {
    const answer = absolutes.reduce((acc,cur,idx)=>{
        acc+=cur*(signs[idx]?1:-1);
        return acc;
    },0)
    return answer;
}