function solution(n) {
    const answer = Math.sqrt(n)%1===0?1:2;
    return answer;
}