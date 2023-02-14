function solution(num, k) {
    const answer = String(num).indexOf(k)+1||-1
    return answer;
}