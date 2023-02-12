function solution(array) {
    const max=Math.max(...array);
    const answer=[max,array.indexOf(max)]
    return answer;
}