function solution(numbers) {
    numbers.sort((a,b)=>a-b);
    const answer = Math.max(numbers[0]*numbers[1],numbers.at(-1)*numbers.at(-2));
    return answer;
}