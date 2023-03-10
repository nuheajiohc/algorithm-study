function solution(n) {
    let answer = n.toString(3).split("").reverse().join("");
    answer = parseInt(answer,3);
    return answer;
}