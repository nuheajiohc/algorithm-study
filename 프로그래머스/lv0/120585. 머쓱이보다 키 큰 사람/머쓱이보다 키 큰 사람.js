function solution(array, height) {
    const answer = array.reduce((acc,cur)=>height<cur?acc+1:acc,0);
    return answer;
}