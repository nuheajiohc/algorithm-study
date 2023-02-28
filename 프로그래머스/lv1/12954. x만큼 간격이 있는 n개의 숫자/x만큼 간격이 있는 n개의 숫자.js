function solution(x, n) {
    const answer = Array.from({length:n},(el,i)=>x*(i+1));
    return answer;
}