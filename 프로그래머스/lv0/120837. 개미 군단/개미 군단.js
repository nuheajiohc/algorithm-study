function solution(hp) {
    const answer =Math.floor(hp/5)+Math.floor(hp%5/3)+hp%5%3;
    return answer;
}