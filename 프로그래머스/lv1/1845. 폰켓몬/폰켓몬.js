function solution(nums) {
    const uniqueNums = new Set(nums);
    const answer = uniqueNums.size>=nums.length/2?nums.length/2:uniqueNums.size;
    return answer;
}