function solution(my_string) {
    var answer = [...my_string.toLowerCase()].sort().join("");
    return answer;
}