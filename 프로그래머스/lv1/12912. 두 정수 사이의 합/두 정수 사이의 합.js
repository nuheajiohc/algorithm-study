function solution(a, b) {
    const answer = Array.from({length:Math.abs(a-b)+1},(_,i)=>Math.min(a,b)+i).reduce((acc,cur)=>acc+cur,0);
    return answer;
}