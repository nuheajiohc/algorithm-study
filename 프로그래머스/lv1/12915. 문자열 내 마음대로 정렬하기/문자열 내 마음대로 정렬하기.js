function solution(strings, n) {
    const answer = strings.sort((a,b)=>a[n].localeCompare(b[n])||a.localeCompare(b));
    return answer;
}