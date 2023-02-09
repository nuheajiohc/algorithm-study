function solution(num_list) {
    const answer = [0,0];
    num_list.forEach(el=>answer[el%2]+=1);
    return answer;
}
