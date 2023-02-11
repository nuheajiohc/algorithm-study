function solution(n, numlist) {
    const answer = numlist.filter(el=>el%n===0);
    return answer;
}
