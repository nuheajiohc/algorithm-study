function solution(numbers) {
    const answer = numbers.reduce((acc,cur)=>acc+cur,0)/numbers.length;
    return answer;
}