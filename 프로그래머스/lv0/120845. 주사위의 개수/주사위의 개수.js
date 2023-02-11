function solution(box, n) {
    const answer=box.reduce((acc,cur)=>Math.floor(cur/n)*acc,1);
    return answer;
}