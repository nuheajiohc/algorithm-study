function solution(phone_number) {
    const answer = "*".repeat(phone_number.length-4)+phone_number.slice(-4);
    return answer;
}