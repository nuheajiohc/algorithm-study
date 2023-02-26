function solution(dots) {
    dots.sort((a,b)=>a[0]-b[0]||a[1]-b[1]);
    const answer = (dots[3][0]-dots[0][0]) * (dots[3][1]-dots[0][1]);
    return answer;
}