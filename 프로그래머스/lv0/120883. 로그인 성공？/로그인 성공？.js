function solution(id_pw, db) {
    let answer = "fail";
    const dbMap = new Map(db);
    if(dbMap.has(id_pw[0])){
        answer = "wrong pw";
        if(dbMap.get(id_pw[0])===id_pw[1]) answer = "login";
    }
    return answer;
}