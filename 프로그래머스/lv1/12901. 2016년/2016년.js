function solution(a, b) {
    const week= ["SUN","MON","TUE","WED","THU","FRI","SAT"];
    const days=[31,29,31,30,31,30,31,31,30,31,30,31];
    let totalDays=0;
    for(let day=0; day<a-1;day+=1){
        totalDays+=days[day];
    }
    totalDays+=b;
    
    const answer = week[(totalDays+4)%7];
    return answer;
}