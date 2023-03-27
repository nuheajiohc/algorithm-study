function solution(lottos, win_nums) {
    const rank={
        0:6,
        1:6,
        2:5,
        3:4,
        4:3,
        5:2,
        6:1,
    }
    
    const answer = [];
    let match=0;
    const setWin_nums = new Set(win_nums);
    const secretNumbers=lottos.filter(number=>number===0).length;
    lottos.forEach(number=>{
        if(setWin_nums.has(number)){
            match+=1;
        }
    })
    answer.push(rank[match+secretNumbers]);
    answer.push(rank[match]);
    return answer;
}