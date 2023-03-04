function solution(s) {
    const length = s.length;
    const answer =s.length%2===0?s.slice((length/2)-1,(length/2)+1):s[Math.floor(length/2)];
    return answer;
}