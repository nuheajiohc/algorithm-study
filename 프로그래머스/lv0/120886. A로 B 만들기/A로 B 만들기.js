function solution(before, after) {
    const answer = before.split("").sort().join("")===after.split("").sort().join("")?1:0;
    return answer;
}