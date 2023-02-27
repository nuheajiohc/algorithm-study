function solution(quiz) {
    const answer = quiz.map(el=>{
        const [before,after]=el.split(" = ");
        const operation=before.split(" ");
        let sign =1;
        const beforeResult=operation.reduce((acc,cur)=>{
            if(cur==="-") sign=-1;
            else if(cur==="+") sign=1;
            else acc+=cur*sign;
            return acc;
        },0)
        if(beforeResult===Number(after)) return "O";
        else return "X";
    });
    return answer;
}