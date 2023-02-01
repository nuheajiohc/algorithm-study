function solution(N, stages) {
    var answer = [];
    const failer =new Array(N).fill(0);
    stages.forEach(el=>{
        if(Number(el)>Number(N)) return;
        failer[el-1]+=1;
    })
    let number=stages.length;
    const failRate=failer.map((el,i)=>{
        const result=el/number;
        number-=el;
        return [i+1,result];
    })
    answer =failRate.sort((a,b)=>b[1]-a[1]||a[0]-b[0]).map(el=>el[0]);
    
    return answer;
}


// 2번 스테이지 3
// 1번 스테이지 1
// 3번 스테이지 2
// 4번 스테이지 1
// 5번 스테이지 0
// 6번 스테이지 1