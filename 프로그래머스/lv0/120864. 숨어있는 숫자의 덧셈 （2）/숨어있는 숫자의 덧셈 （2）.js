function solution(my_string) {
    const answer = my_string.replace(/\D+/g," ").trim().split(" ").reduce((acc,cur)=>acc+Number(cur),0);
    return answer;
}