function solution(t, p) {
    let answer = 0;
    for(let i=0;i<=t.length-p.length;i+=1){
        Number(t.slice(i,i+p.length))<=Number(p)&&answer++;
    }
    return answer;
}