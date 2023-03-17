function solution(a, b, n) {
    let answer = 0;
    function cola(bottle){
        if(a>bottle) return answer;
        const emptyBottle=Math.floor(bottle/a) * b;
        const leftCola = bottle%a;
        answer+=emptyBottle;
        cola(emptyBottle+leftCola);
    }
    cola(n);
    return answer;
}