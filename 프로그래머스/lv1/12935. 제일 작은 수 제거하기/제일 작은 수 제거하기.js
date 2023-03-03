function solution(arr) {
    const minNum=[...arr].sort((a,b)=>b-a).pop();
    arr.splice(arr.indexOf(minNum),1)
    const answer = arr.length?arr:[-1];
    return answer;
}