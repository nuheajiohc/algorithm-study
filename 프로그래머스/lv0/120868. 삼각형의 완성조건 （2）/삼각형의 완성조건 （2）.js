function solution(sides) {
    const answer = sides[0]+sides[1]-Math.abs(sides[1]-sides[0])-1;
    return answer;
}