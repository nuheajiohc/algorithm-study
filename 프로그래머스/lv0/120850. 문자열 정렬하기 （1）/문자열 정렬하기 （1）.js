function solution(my_string) {
    const answer = my_string.replace(/[^0-9]/g,"").split("").sort().map(Number);
    return answer;
}