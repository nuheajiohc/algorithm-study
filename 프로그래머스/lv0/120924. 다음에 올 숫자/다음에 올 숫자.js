function solution(common) {
    const answer=common[0]-common[1] ===common[1]-common[2]? common.at(-1)+common[1]-common[0]: common.at(-1)*common[1]/common[0];
    return answer;
}