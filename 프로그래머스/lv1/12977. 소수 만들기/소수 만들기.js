function solution(nums) {
    let answer = 0;
    const sortedNums = [...nums].sort((a,b)=>a-b);
    const maxSum = sortedNums.at(-3)+sortedNums.at(-2)+sortedNums.at(-1);
    const arr = new Array(maxSum+1).fill(-1).fill(0,2,0);
    for(let i=2;i<=maxSum;i+=1){
        if(arr[i]!==-1) continue;
        arr[i]=i;
        for(let j=i+i;j<=maxSum;j+=i){
            arr[j]=0;
        }
    }
    const primeNumber = new Set(arr.filter((el,i)=>el===i));
    
    for(let i=0;i<sortedNums.length-2;i+=1){
        for(let j=i+1;j<sortedNums.length-1;j+=1){
            for(let k=j+1;k<sortedNums.length;k+=1){
              const sum=(sortedNums[i]+sortedNums[j]+sortedNums[k]);
                if(primeNumber.has(sum)) answer+=1;
            }
        }
    }
    return answer;
}