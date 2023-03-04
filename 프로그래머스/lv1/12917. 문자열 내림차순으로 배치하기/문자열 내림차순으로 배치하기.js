function solution(s) {
    const answer = s.split("").sort().reverse().join("");
    return answer;
}