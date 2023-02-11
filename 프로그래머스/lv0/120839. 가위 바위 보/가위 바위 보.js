function solution(rsp) {
    const win={
        2:0,
        0:5,
        5:2,
    }
    const answer=[...rsp].map(el=>win[el]).join("");
    return answer;
}