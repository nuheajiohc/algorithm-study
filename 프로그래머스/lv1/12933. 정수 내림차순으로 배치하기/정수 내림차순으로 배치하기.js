function solution(n) {
    const answer = Number(n.toString().split("").sort((a,b)=>b-a).join(""));
    return answer;
}