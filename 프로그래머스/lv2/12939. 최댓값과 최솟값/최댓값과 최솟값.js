function solution(s) {
    const sSort = s.split(" ").map(Number).sort((a,b)=>a-b);
    const answer = `${sSort.at(0)} ${sSort.at(-1)}`;
    return answer;
}