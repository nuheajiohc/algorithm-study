function solution(n) {
    const answer = Array.from({length:Math.ceil(n/2)},(_,i)=>(i+1)*2-1);
    return answer;
}