function solution(n) {
    const str ="수박".repeat(Math.floor(n/2));
    const answer = n%2===0?str:str+"수"; 
    return answer;
}