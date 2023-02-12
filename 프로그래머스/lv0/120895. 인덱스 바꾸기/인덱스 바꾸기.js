function solution(my_string, num1, num2) {
    const list= my_string.split("");
    [list[num1],list[num2]]=[list[num2],list[num1]];
    const answer =list.join("")
    return answer;
}