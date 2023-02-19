function solution(num_list, n) {
    const answer = [];
    for(let i=0;i<num_list.length;i+=1){
        const a=[];
        while((i+1)%n!==0){
            a.push(num_list[i])
            i+=1;
        }
        a.push(num_list[i]);
        answer.push(a);
    }
    return answer;
}