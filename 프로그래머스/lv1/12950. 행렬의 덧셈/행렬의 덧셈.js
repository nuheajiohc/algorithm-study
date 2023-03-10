function solution(arr1, arr2) {
    const answer = arr1.map((row,i)=>{
        return row.map((column,j)=>{
            return column+arr2[i][j];
        })
    })
    return answer;
}