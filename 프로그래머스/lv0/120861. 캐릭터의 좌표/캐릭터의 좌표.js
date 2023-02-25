function solution(keyinput, board) {
    const answer = [0,0];
    const key = {
        left:[-1, 0],
        right:[1, 0],
        up:[0, 1],
        down: [0, -1],
    }
    keyinput.forEach(command=>{
        if(answer[0]===(board[0]-1)/2 && command==="right") return;
        else if(answer[0]===(board[0]-1)/-2 && command==="left") return;
        else if (answer[1]===(board[1]-1)/2 && command==="up") return;
        else if(answer[1]===(board[1]-1)/-2 && command==="down") return;
        answer[0]+=key[command][0];
        answer[1]+=key[command][1];
    })
    return answer;
}