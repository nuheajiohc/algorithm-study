function solution(numbers, k) {
    const answer = numbers[(2*k-2)%numbers.length];
    return answer;
}