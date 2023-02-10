function solution(array, n) {
    const answer = array.reduce((acc,cur)=>cur===n?acc+1:acc,0)
    return answer;
}