function solution(numlist, n) {
    const answer = numlist.sort((a,b)=>Math.abs(a-n)-Math.abs(b-n)||b-a);
    return answer;
}