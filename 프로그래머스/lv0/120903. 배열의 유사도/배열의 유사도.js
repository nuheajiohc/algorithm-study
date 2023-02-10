function solution(s1, s2) {
    const answer = s1.length+s2.length-new Set([...s1,...s2]).size;
    return answer;
}