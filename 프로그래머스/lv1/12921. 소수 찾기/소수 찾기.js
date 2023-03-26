function solution(n) {
    const arr = new Array(n+1).fill(-1).fill(0,2,0);
    for(let i=2;i<=n;i+=1){
        if(arr[i]!==-1) continue;
        arr[i]=1;
        for(let j=i+i;j<=n;j+=i){
            arr[j]=0;
        }
    }
    return arr.filter(el=>el===1).length;
}