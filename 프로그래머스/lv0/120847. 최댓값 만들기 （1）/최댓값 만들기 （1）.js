function solution(numbers) {
    numbers.sort((a,b)=>a-b);
    const answer = numbers.at(-1)*numbers.at(-2);
    return answer;
}