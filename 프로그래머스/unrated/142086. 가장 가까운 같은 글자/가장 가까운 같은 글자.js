function solution(s) {
    const answer= [];
    const alphabet={}
    for(let i=0;i<s.length;i+=1){
        if(alphabet[s[i]]===undefined){
            alphabet[s[i]]=i;
            answer.push(-1);
            continue;
        }
        answer.push(i-alphabet[s[i]])
        alphabet[s[i]]=i;
    }
    return answer;
}