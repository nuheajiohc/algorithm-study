function solution(numbers, direction) {
    const start=direction==="right"?numbers.length-1:1;
    const answer = [...numbers,...numbers].slice(start,start+numbers.length);
    return answer;
}